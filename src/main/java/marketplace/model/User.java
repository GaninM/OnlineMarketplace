package marketplace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    @Transient
    private String userPasswordConfirm;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(String fullName, String username, String userPassword, String userPasswordConfirm, Set<Role> roles) {
        this.fullName = fullName;
        this.username = username;
        this.userPassword = userPassword;
        this.userPasswordConfirm = userPasswordConfirm;
        this.roles = roles;
    }
}
