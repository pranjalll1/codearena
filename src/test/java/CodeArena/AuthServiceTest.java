package CodeArena;

import CodeArena.dto.LoginRequest;
import CodeArena.dto.RegisterRequest;
import CodeArena.model.User;
import CodeArena.repository.UserRepository;
import CodeArena.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @InjectMocks private AuthService authService;

    @Test
    public void testRegister_Success() {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("pranjal");
        req.setEmail("pranjal@test.com");
        req.setPassword("pass123");
        when(userRepository.existsByUsername("pranjal")).thenReturn(false);
        when(userRepository.existsByEmail("pranjal@test.com")).thenReturn(false);
        when(passwordEncoder.encode("pass123")).thenReturn("encoded");
        String result = authService.register(req);
        assertEquals("User registered successfully", result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testRegister_UsernameTaken() {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("pranjal");
        req.setEmail("pranjal@test.com");
        req.setPassword("pass123");
        when(userRepository.existsByUsername("pranjal")).thenReturn(true);
        String result = authService.register(req);
        assertEquals("Username already taken", result);
    }

    @Test
    public void testLogin_UserNotFound() {
        LoginRequest req = new LoginRequest();
        req.setUsername("unknown");
        req.setPassword("pass");
        when(userRepository.findByUsername("unknown")).thenReturn(Optional.empty());
        String result = authService.login(req);
        assertEquals("User not found", result);
    }

    @Test
    public void testLogin_InvalidPassword() {
        LoginRequest req = new LoginRequest();
        req.setUsername("pranjal");
        req.setPassword("wrongpass");
        User user = new User();
        user.setUsername("pranjal");
        user.setPassword("encodedpass");
        when(userRepository.findByUsername("pranjal")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpass", "encodedpass")).thenReturn(false);
        String result = authService.login(req);
        assertEquals("Invalid password", result);
    }
}
