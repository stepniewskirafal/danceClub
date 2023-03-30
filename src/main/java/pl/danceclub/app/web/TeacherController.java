package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
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
    public String getTeacher(@PathVariable long id,
                             Model model) {
        TeacherDto teacherDto = teacherService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("teacher", teacherDto);
        return "teacher";
    }
}
