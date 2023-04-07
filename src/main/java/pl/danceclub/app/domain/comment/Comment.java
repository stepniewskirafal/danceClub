package pl.danceclub.app.domain.comment;

import jakarta.persistence.*;
import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.unit.Unit;
import pl.danceclub.app.user.User;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Comment(Long id, String comment, User user, Unit unit, Teacher teacher) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.unit = unit;
        this.teacher = teacher;
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
