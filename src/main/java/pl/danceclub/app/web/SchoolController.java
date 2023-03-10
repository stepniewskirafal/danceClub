package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.danceclub.app.domain.school.Dto.SchoolDto;
import pl.danceclub.app.domain.school.SchoolService;

import java.util.Optional;

@Controller
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/school/{id}")
    public String getMovie(@PathVariable long id, Model model) {
        SchoolDto schoolDto = schoolService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("school", schoolDto);
        return "school";
    }
}
