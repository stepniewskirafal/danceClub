package pl.danceclub.app.domain.rating;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.teacher.TeacherRepository;
import pl.danceclub.app.domain.unit.Unit;
import pl.danceclub.app.domain.unit.UnitRepository;
import pl.danceclub.app.user.User;
import pl.danceclub.app.user.UserRepository;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final UnitRepository unitRepository;
    private final TeacherRepository teacherRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, UnitRepository unitRepository, TeacherRepository teacherRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
        this.teacherRepository = teacherRepository;
    }

    public void addOrUpdateUnitRating(String userEmail, long unitId, int unitRate) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndUnit_id(userEmail, unitId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Unit unit = unitRepository.findById(unitId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setUnit(unit);
        ratingToSaveOrUpdate.setUnit_rate(unitRate);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForUnit(String userEmail, long unitId) {
        return ratingRepository
                .findByUser_EmailAndUnit_id(userEmail, unitId)
                .map(Rating::getUnit_rate);
    }

    public Optional<Integer> getUserRatingForTeacher(String userEmail, long teacherId) {
        return ratingRepository
                .findByUser_EmailAndTeacher_id(userEmail, teacherId)
                .map(Rating::getTeacher_rate);
    }

    public void addOrUpdateTeacherRating(String userEmail, long teacherId, int teacherRate) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndTeacher_id(userEmail, teacherId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setTeacher(teacher);
        ratingToSaveOrUpdate.setTeacher_rate(teacherRate);
        ratingRepository.save(ratingToSaveOrUpdate);
    }
}