package pl.danceclub.app.domain.school;

import pl.danceclub.app.domain.school.Dto.SchoolDto;
import pl.danceclub.app.domain.unit.dto.UnitDto;

public class SchoolDtoMapper {
    static SchoolDto map(School school) {

        return new SchoolDto(
                school.getId(),
                school.getName(),
                school.getAddress(),
                school.getDescription()
        );
    }
}