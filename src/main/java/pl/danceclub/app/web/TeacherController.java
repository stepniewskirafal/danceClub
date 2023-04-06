package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.Authentication;
import pl.danceclub.app.domain.rating.RatingService;
import pl.danceclub.app.domain.teacher.TeacherService;
import pl.danceclub.app.domain.teacher.dto.TeacherDto;

import java.util.List;

@Controller
public class TeacherController {
    private final TeacherService teacherService;
    private final RatingService ratingService;

    public TeacherController(TeacherService teacherService, RatingService ratingService) {
        this.teacherService = teacherService;
        this.ratingService = ratingService;
    }

    @GetMapping("/teacher/{id}")
    public String getTeacher(@PathVariable long id,
                             Model model,
                             Authentication authentication) {
        TeacherDto teacherDto = teacherService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("teacher", teacherDto);
        //Jeżeli użytkownik jest zalogowany
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            //to wyszukujemy jego głos
            Integer rating = ratingService.getUserRatingForTeacher(currentUserEmail, id).orElse(0);
            //i zapisujemy go w modelu
            model.addAttribute("userRating", rating);
        }
        return "teacher";
    }

    @GetMapping("/teachers")
    public String getGenres(Model model){
        List<TeacherDto> teacherDtoList = teacherService.findAll();
        model.addAttribute("teachers", teacherDtoList);
        return "teacher-listing";
    }
}
