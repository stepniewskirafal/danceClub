package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.danceclub.app.domain.comment.CommentService;
import pl.danceclub.app.domain.comment.dto.CommentDto;
import pl.danceclub.app.domain.rating.RatingService;
import pl.danceclub.app.domain.unit.UnitService;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;

@Controller
public class UnitController {
    private final UnitService unitService;
    private final RatingService ratingService;
    private final CommentService commentService;

    public UnitController(UnitService unitService, RatingService ratingService, CommentService commentService) {
        this.unitService = unitService;
        this.ratingService = ratingService;
        this.commentService = commentService;
    }

    @GetMapping("/unit/{id}")
    public String getUnit(@PathVariable long id,
                           Model model,
                           Authentication authentication) {
        UnitDto unitDto = unitService.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("unit", unitDto);
        //Jeżeli użytkownik jest zalogowany
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            //to wyszukujemy jego głos
            Integer rating = ratingService.getUserRatingForUnit(currentUserEmail, id).orElse(0);
            //i zapisujemy go w modelu
            model.addAttribute("userRating", rating);
        }

        List<CommentDto> commentList = commentService.getAllUnitComment(id);
        model.addAttribute("comments", commentList);

        return "unit";
    }

    @GetMapping("/top10Classes")
    public String findTop10(Model model) {
        List<UnitDto> top10Movies = unitService.findTopUnits(10);
        model.addAttribute("heading", "TOP10 zajęć tancznych");
        model.addAttribute("description", "Zajęcia najlepiej oceniane przez uczestników");
        model.addAttribute("units", top10Movies);
        return "unit-listing";
    }
}
