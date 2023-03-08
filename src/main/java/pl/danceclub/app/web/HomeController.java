package pl.danceclub.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.danceclub.app.domain.unit.UnitService;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;

@Controller
public class HomeController {

    private final UnitService unitService;

    public HomeController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<UnitDto> allPromotedUnits = unitService.findAllPromotedUnits();
        model.addAttribute("heading", "Promowane zajęcia");
        model.addAttribute("description", "Wybrane za pomocą Waszego głosowania");
        model.addAttribute("units", allPromotedUnits);
        return "unit-listing";
    }
}
