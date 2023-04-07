package pl.danceclub.app.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.danceclub.app.domain.comment.CommentService;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment-unit")
    public String addComment(@RequestParam long unitId,
                             @RequestParam String comment,
                             @RequestHeader String referer,
                             Authentication authentication) {
        String currentUserEmail = authentication.getName();

        commentService.addCommentToUnit(currentUserEmail, unitId, comment);
        return "redirect:" + referer;
    }
}
