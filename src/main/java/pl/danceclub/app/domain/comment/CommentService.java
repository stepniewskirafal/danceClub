package pl.danceclub.app.domain.comment;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.comment.dto.CommentDto;
import pl.danceclub.app.domain.rating.Rating;
import pl.danceclub.app.domain.teacher.Teacher;
import pl.danceclub.app.domain.unit.Unit;
import pl.danceclub.app.domain.unit.UnitRepository;
import pl.danceclub.app.user.User;
import pl.danceclub.app.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UnitRepository unitRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UnitRepository unitRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    public List<CommentDto> getAllUnitComment(long id) {
        List<CommentDto> commentDtoList = commentRepository.findAllByUnit_Id(id)
                .stream()
                .map(CommentDtoMapper::map)
                .collect(Collectors.toList());

        return commentDtoList;
    }

    public void addCommentToUnit(String userEmail, long unitId, String comment) {
        Unit unitById = unitRepository.findById(unitId).orElseThrow();
        User user     = userRepository.findByEmail(userEmail).orElseThrow();
        Comment commentToSave = new Comment();
        commentToSave.setUser(user);
        commentToSave.setUnit(unitById);
        commentToSave.setComment(comment);
        commentRepository.save(commentToSave);
    }

}
