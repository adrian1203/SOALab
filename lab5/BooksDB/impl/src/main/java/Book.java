import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Remote;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.TABLE;

@Getter
@Setter
@Entity
@Table(name = "book")
@Remote(BookInterface.class)
public class Book implements BookInterface, Serializable {

    @Id
    @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Double price;


    public Book() {
    }


}
