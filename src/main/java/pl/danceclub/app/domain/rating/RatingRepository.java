package pl.danceclub.app.domain.rating;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findByUser_EmailAndUser (String userEmail, Long unitId);
}
