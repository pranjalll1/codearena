package CodeArena.dto;
public class RegisterRequest {
    private String username, email, password;
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setUsername(String v) { this.username=v; }
    public void setEmail(String v) { this.email=v; }
    public void setPassword(String v) { this.password=v; }
}
