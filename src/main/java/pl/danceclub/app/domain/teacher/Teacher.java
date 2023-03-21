package pl.danceclub.app.domain.teacher;


import jakarta.persistence.*;
import pl.danceclub.app.domain.genre.Genre;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String short_description;
    private String description;
    private String youtube_trailer_id;
    private String poster;
    private boolean promoted;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName="id")
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutube_trailer_id() {
        return youtube_trailer_id;
    }

    public void setYoutube_trailer_id(String youtube_trailer_id) {
        this.youtube_trailer_id = youtube_trailer_id;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
