package pl.danceclub.app.domain.teacher;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

@Service
public class TeacherDtoMapper {
    static TeacherDto map(Teacher teacher) {

        return new TeacherDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getShort_description(),
                teacher.getDescription(),
                teacher.getYoutube_trailer_id(),
                teacher.isPromoted(),
                teacher.getGenre_id()
        );
    }
}
