import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private Long id;

    @Column(name = "currency_name", length = 50)
    private String name;

    @Column(name = "currency_description", length = 255)
    private String description;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
