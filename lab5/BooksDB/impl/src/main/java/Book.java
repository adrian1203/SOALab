import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Remote;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

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


    @Column(name = "title")
    private String title;

   @ManyToOne
   private Author author;

   @OneToMany
   private Set<Rental> rentalSet;


    public Book() {
    }


}
