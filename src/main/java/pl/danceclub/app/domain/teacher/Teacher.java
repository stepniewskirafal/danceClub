package pl.danceclub.app.domain.teacher;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    private String promoted;
    private boolean genre_id;

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

    public String getPromoted() {
        return promoted;
    }

    public void setPromoted(String promoted) {
        this.promoted = promoted;
    }

    public boolean isGenre_id() {
        return genre_id;
    }

    public void setGenre_id(boolean genre_id) {
        this.genre_id = genre_id;
    }
}
