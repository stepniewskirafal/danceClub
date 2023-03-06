package pl.danceclub.app.domain.unit;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.unit.dto.UnitDto;


@Service
public class UnitDtoMapper {

    UnitDto map(Unit unit) {
        return new UnitDto(
                unit.getId(),
                unit.getName(),
                unit.isPromoted(),
                unit.getSchool().getName(),
                unit.getFemale_teacher().getName() + " " + unit.getFemale_teacher().getSurname(),
                unit.getMale_teacher().getName() + " " + unit.getMale_teacher().getSurname()
        );
    }

}
