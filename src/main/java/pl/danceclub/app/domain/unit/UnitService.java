package pl.danceclub.app.domain.unit;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.genre.dto.GenreDto;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Optional<UnitDto> findById(Long id){
        return unitRepository.findById(id).map(UnitDtoMapper::map);
    }

    public List<UnitDto> findAllPromotedUnits(){
        return unitRepository.findAllByPromotedIsTrue()
                .stream()
                .map(UnitDtoMapper::map)
                .collect(Collectors.toList());
    }

    public List<UnitDto> findAll(){
        return StreamSupport.stream(unitRepository.findAll().spliterator(), false)
                .map(UnitDtoMapper::map)
                .collect(Collectors.toList());
    }

    public List<UnitDto> findAllByGenre(String name){
        return unitRepository.findAllByGenre_Name(name)
                .stream()
                .map(UnitDtoMapper::map)
                .collect(Collectors.toList());
    }

    public List<UnitDto> findTopUnits(int size) {
        Pageable page = Pageable.ofSize(size);
        return unitRepository.findTopByRating(page).stream()
                .map(UnitDtoMapper::map)
                .toList();
    }
}
