package pl.danceclub.app.domain.comment;

import pl.danceclub.app.domain.comment.dto.CommentDto;

public class CommentDtoMapper {

    static CommentDto map(Comment comment) {

        return new CommentDto(
                comment.getId(),
                comment.getComment(),
                comment.getUser().getEmail(),
                comment.getUnit(),
                comment.getTeacher()
        );
    }

}
