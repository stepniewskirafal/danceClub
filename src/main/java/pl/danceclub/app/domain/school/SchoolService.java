package pl.danceclub.app.domain.school;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.school.Dto.SchoolDto;
import pl.danceclub.app.domain.school.Dto.SchoolSaveDto;
import pl.danceclub.app.storage.FileStorageService;

import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final FileStorageService fileStorageService;

    public SchoolService(SchoolRepository schoolRepository, FileStorageService fileStorageService) {
        this.schoolRepository = schoolRepository;
        this.fileStorageService = fileStorageService;
    }

    public Optional<SchoolDto> findById(Long id){
        return schoolRepository.findById(id).map(SchoolDtoMapper::map);
    }

    public void addSchool(SchoolSaveDto schoolSaveDto) {
        School school = new School();
        school.setName(schoolSaveDto.getName());
        school.setDescription(schoolSaveDto.getDescription());
        school.setAddress(schoolSaveDto.getAddress());
        if (schoolSaveDto.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(schoolSaveDto.getPoster());
            school.setPoster(savedFileName);
        }
        schoolRepository.save(school);
    }

}
