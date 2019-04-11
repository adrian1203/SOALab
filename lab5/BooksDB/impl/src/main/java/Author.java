import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.TABLE;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @OneToMany
    private Set<Book> bookSet;
}
