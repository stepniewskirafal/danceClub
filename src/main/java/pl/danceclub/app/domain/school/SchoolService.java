package pl.danceclub.app.domain.school;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.school.Dto.SchoolDto;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    public Optional<SchoolDto> findById(Long id){
        return schoolRepository.findById(id).map(SchoolDtoMapper::map);
    }

}
