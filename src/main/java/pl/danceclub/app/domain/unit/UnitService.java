package pl.danceclub.app.domain.unit;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;
import java.util.stream.Collectors;

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
}
