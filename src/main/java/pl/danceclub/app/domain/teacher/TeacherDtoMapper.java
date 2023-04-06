package pl.danceclub.app.domain.teacher;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.rating.Rating;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

@Service
public class TeacherDtoMapper {

    static TeacherDto map(Teacher teacher) {
        double avgRating = teacher.getRatings()
                .stream()
                .map(Rating::getTeacher_rate)
                .filter(x->x!=null)
                .mapToDouble(x -> x)
                .average().orElse(0);

        long ratingCount = teacher.getRatings()
                .stream()
                .map(Rating::getTeacher_rate)
                .filter(x -> x != null)
                .count();

        return new TeacherDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getShort_description(),
                teacher.getDescription(),
                teacher.getYoutube_trailer_id(),
                teacher.getPoster(),
                teacher.isPromoted(),
                teacher.getGenre().getName(),
                avgRating,
                ratingCount
        );
    }
}
