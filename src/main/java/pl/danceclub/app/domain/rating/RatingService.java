package pl.danceclub.app.domain.rating;

import org.springframework.stereotype.Service;
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

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, UnitRepository unitRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
    }

    public void addOrUpdateRating(String userEmail, long unitId, int unitRate) {
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
}