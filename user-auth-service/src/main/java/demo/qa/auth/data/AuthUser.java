package demo.qa.auth.data;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_users")
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // можно добавить поле роль
    private String role;

    // конструкторы
    public AuthUser() {
    }

    public AuthUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getters, setters

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
