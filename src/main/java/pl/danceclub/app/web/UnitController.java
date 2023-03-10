package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
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
        UnitDto unitDto = unitService.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("unit", unitDto);
        return "unit";
    }


}
