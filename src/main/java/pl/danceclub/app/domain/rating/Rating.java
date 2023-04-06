package pl.danceclub.app.domain.rating;

import jakarta.persistence.*;
import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.unit.Unit;
import pl.danceclub.app.user.User;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    private Integer unit_rate;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    private Integer teacher_rate;

    public Rating() {
    }

    public Rating(Long id, User user, Unit unit, Integer unit_rate, Teacher teacher, Integer teacher_rate) {
        this.id = id;
        this.user = user;
        this.unit = unit;
        this.unit_rate = unit_rate;
        this.teacher = teacher;
        this.teacher_rate = teacher_rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getUnit_rate() {
        return unit_rate;
    }

    public void setUnit_rate(Integer unit_rate) {
        this.unit_rate = unit_rate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getTeacher_rate() {
        return teacher_rate;
    }

    public void setTeacher_rate(Integer teacher_rate) {
        this.teacher_rate = teacher_rate;
    }
}