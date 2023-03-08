package pl.danceclub.app.domain.unit;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    private final UnitDtoMapper unitDtoMapper;

    public UnitService(UnitRepository unitRepository, UnitDtoMapper unitDtoMapper) {
        this.unitRepository = unitRepository;
        this.unitDtoMapper = unitDtoMapper;
    }

    public List<UnitDto> findAllPromotedUnits(){
        return unitRepository.findAllByPromotedIsTrue()
                .stream()
                .map(unit -> unitDtoMapper.map(unit))
                .collect(Collectors.toList());
    }

    public List<UnitDto> findAll(){
        Stream<Unit> stream = StreamSupport.stream(unitRepository.findAll().spliterator(), false);
        Stream<UnitDto> unitDtoStream = stream.map(unit -> unitDtoMapper.map(unit));
        List<UnitDto> collect = unitDtoStream.collect(Collectors.toList());
        return collect;
    }
}
