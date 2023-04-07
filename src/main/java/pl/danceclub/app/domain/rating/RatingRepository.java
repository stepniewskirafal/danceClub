package pl.danceclub.app.domain.rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findByUser_EmailAndUnit_id(String userEmail, Long unitId);
    Optional<Rating> findByUser_EmailAndTeacher_id(String userEmail, Long teacherId);
}
