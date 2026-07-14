package CodeArena.service;
import CodeArena.dto.LoginRequest;
import CodeArena.dto.RegisterRequest;
import CodeArena.model.User;
import CodeArena.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public String register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) return "Username already taken";
        if (userRepository.existsByEmail(request.getEmail())) return "Email already registered";
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.USER)
                .build();
        userRepository.save(user);
        return "User registered successfully-Demo";
    }
    public String login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);
        if (user == null) return "User not found";
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) return "Invalid password";
        return "Login successful - Welcome " + user.getUsername();
    }
}
