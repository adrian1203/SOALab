package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rental_user")
public class RentalUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUST_GEN")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_namee")
    private String lastName;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Film> films=new HashSet<Film>();

    public RentalUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RentalUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
