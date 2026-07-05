package CodeArena.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true) private String username;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String password;
    @Enumerated(EnumType.STRING) private Role role;
    public enum Role { USER, ADMIN }
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String u) { this.username = u; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
    public Role getRole() { return role; }
    public void setRole(Role r) { this.role = r; }
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private User u = new User();
        public Builder username(String v) { u.username=v; return this; }
        public Builder email(String v) { u.email=v; return this; }
        public Builder password(String v) { u.password=v; return this; }
        public Builder role(Role v) { u.role=v; return this; }
        public User build() { return u; }
    }
}
