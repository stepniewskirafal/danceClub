package pl.danceclub.app.domain.teacher;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Optional<TeacherDto> findById(Long id){
        return teacherRepository.findById(id).map(TeacherDtoMapper::map);
    }
}
