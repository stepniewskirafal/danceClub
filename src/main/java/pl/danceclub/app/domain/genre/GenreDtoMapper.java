package pl.danceclub.app.domain.genre;

import org.springframework.stereotype.Service;
import pl.danceclub.app.domain.genre.dto.GenreDto;

@Service
public class GenreDtoMapper {

    static GenreDto map(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getDescription()
        );
    }
}
