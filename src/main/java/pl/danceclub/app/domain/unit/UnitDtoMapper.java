package pl.danceclub.app.domain.unit;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.rating.Rating;
import pl.danceclub.app.domain.unit.dto.UnitDto;

@Service
public class UnitDtoMapper {
    static UnitDto map(Unit unit) {
        double avgRating = unit.getRatings().stream()
                .map(Rating::getUnit_rate)
                .filter(str -> str!=null)
                .mapToDouble(val -> val)
                .average().orElse(0);
        long ratingCount = unit.getRatings().stream()
                .map(Rating::getUnit_rate)
                .filter(x -> x != null)
                .count();

        return new UnitDto(
                unit.getId(),
                unit.getName(),
                unit.getSchool().getId(),
                unit.getSchool().getName(),
                unit.getFemale_teacher().getName() + " " + unit.getFemale_teacher().getSurname(),
                unit.getFemale_teacher().getId(),
                unit.getMale_teacher().getName() + " " + unit.getMale_teacher().getSurname(),
                unit.getMale_teacher().getId(),
                unit.getShort_description(),
                unit.getDescription(),
                unit.getGenre().getName(),
                unit.getGenre().getId(),
                unit.getPoster(),
                avgRating,
                ratingCount,
                unit.isPromoted()
        );
    }
}
