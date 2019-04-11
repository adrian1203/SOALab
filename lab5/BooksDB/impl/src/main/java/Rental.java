import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.TABLE;

@Getter
@Setter
@Entity
@Table(name = "rental")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
    private Long id;

    @Column(name = "rental_date")
    private Date rentaDate;

    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
