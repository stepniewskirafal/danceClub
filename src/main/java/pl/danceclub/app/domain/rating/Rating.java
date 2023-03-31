package pl.danceclub.app.domain.rating;

import jakarta.persistence.*;
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

    public Rating() {
    }

    public Rating( User user, Unit unit, Integer unit_rate) {
        this.user = user;
        this.unit = unit;
        this.unit_rate = unit_rate;
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
}