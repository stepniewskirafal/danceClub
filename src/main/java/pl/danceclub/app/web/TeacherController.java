package pl.danceclub.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.danceclub.app.domain.teacher.TeacherService;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

import java.util.Optional;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher/{id}")
    public String getMovie(@PathVariable long id, Model model) {
        Optional<TeacherDto> teacherDtoOptional = teacherService.findById(id);
        teacherDtoOptional.ifPresent(x -> model.addAttribute("teacher", x));
        return "teacher";
    }
}
