package pl.danceclub.app.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.danceclub.app.domain.rating.RatingService;

@Controller
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/rate-unit")
    public String addUnitRating(@RequestParam long unitId,
                                @RequestParam int unitRate,
                                @RequestHeader String referer,
                                Authentication authentication) {
        String currentUserEmail = authentication.getName();
        ratingService.addOrUpdateUnitRating(currentUserEmail, unitId, unitRate);
        return "redirect:" + referer;
    }

    @PostMapping("/rate-teacher")
    public String addTeacherRating(@RequestParam long teacherId,
                                   @RequestParam int teacherRate,
                                   @RequestHeader String referer,
                                   Authentication authentication) {
        String currentUserEmail = authentication.getName();
        ratingService.addOrUpdateTeacherRating(currentUserEmail, teacherId, teacherRate);
        return "redirect:" + referer;
    }
}