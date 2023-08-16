package pl.coderslab.charity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.charity.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nazwa użytkownika nie może być pusta")
    @Size(max = 60, message = "Zbyt długa nazwa użytkownika - masymalnie 60 znaków")
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @Column(nullable = false)
    @Size(max = 200, message = "Zbyt długie hasło")
    @NotBlank(message = "Hasło nie może być puste")
    private String password;
    @Column(nullable = false)
    private int enabled;


    @Column(nullable = false)
    private boolean nonLocked;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    private String firstName;
    private String lastName;
    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }
    public boolean isNonLocked() {
        return nonLocked;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
