import jakarta.persistence.*;


@Entity
@Table(name ="test_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;


    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false, unique = true, length = 255)
    private String user_password;

    @Column(nullable = false, unique = true, length = 255)
    private String email;


    public String getUser_password() {
        return user_password;
    }

    public User(){}

    public User(String username, String user_password, String email) {
        this.username = username;
        this.user_password = user_password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
