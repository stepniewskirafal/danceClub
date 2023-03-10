package pl.danceclub.app.domain.unit;

import jakarta.persistence.*;
import pl.danceclub.app.domain.genre.Genre;
import pl.danceclub.app.domain.school.School;
import pl.danceclub.app.domain.teacher.Teacher;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean promoted;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName="id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "female_teacher_id", referencedColumnName="id")
    private Teacher female_teacher;

    @ManyToOne
    @JoinColumn(name = "male_teacher_id", referencedColumnName="id")
    private Teacher male_teacher;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName="id")
    private Genre genre_id;

    private String short_description;
    private String description;

    public Genre getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Genre genre_id) {
        this.genre_id = genre_id;
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

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher getFemale_teacher() {
        return female_teacher;
    }

    public void setFemale_teacher(Teacher female_teacher) {
        this.female_teacher = female_teacher;
    }

    public Teacher getMale_teacher() {
        return male_teacher;
    }

    public void setMale_teacher(Teacher male_teacher) {
        this.male_teacher = male_teacher;
    }

    public Genre getGenre() {
        return genre_id;
    }

    public void setGenre(Genre dance_genre) {
        this.genre_id = genre_id;
    }
}
