package pl.danceclub.app.domain.comment.dto;

import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.unit.Unit;
import pl.danceclub.app.user.User;

public class CommentDto {

    private Long   id;

    private String comment;

    private String userName;

    private Unit unit;

    private Teacher teacher;

    public CommentDto(Long id, String comment, String userName, Unit unit, Teacher teacher) {
        this.id = id;
        this.comment = comment;
        this.userName = userName;
        this.unit = unit;
        this.teacher = teacher;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
