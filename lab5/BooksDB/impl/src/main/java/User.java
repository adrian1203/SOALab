import lombok.Getter;
import lombok.Setter;

import javax.ejb.Remote;
import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.TABLE;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    private Set<Rental> rentalSet;

}
