package pl.danceclub.app.domain.teacher;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Optional<TeacherDto> findById(Long id){
        return teacherRepository.findById(id).map(TeacherDtoMapper::map);
    }

    public List<TeacherDto> findAll(){
        return StreamSupport.stream(teacherRepository.findAll().spliterator(), false)
                .map(TeacherDtoMapper::map)
                .collect(Collectors.toList());
    }
}
