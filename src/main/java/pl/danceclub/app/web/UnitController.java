package pl.danceclub.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.danceclub.app.domain.unit.UnitService;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.Optional;

@Controller
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/unit/{id}")
    public String getMovie(@PathVariable long id, Model model) {
        Optional<UnitDto> optionalMovie = unitService.findById(id);
        optionalMovie.ifPresent(x -> model.addAttribute("unit", x));
        return "unit";
    }


}
