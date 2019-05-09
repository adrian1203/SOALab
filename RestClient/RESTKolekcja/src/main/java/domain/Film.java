package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUST_GEN")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "uri")
    private String uri;

    public Film(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
