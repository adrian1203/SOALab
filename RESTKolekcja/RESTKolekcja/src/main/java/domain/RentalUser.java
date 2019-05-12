package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rental_user")
public class RentalUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUST_GEN")
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_namee")
    private String lastName;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "Films_RentalUser",
            joinColumns = { @JoinColumn(name = "id_film") },
            inverseJoinColumns = { @JoinColumn(name = "id_user")}
    )
    private Set<Film> films = new HashSet<Film>();

    public RentalUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RentalUser() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long id) {
        this.idUser = id;
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
