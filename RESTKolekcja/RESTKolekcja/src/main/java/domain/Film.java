package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUST_GEN")
    @Column(name = "id_film", nullable = false)
    private Long idFilm;

    @Column(name = "title")
    private String title;

    @Column(name = "uri")
    private String uri;

    @JsonIgnore
    @ManyToMany(mappedBy = "films")
    private Set<RentalUser> rentalUser = new HashSet<RentalUser>();

    public Film(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }

    public Film() {
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Set<RentalUser> getRentalUser() {
        return rentalUser;
    }

    public void setRentalUser(Set<RentalUser> rentalUser) {
        this.rentalUser = rentalUser;
    }
}
