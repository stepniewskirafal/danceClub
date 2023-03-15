package pl.danceclub.app.domain.unit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.danceclub.app.domain.genre.Genre;
import pl.danceclub.app.domain.genre.dto.GenreDto;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {
    List<Unit> findAllByPromotedIsTrue();
    List<Unit> findAllByGenre_Name(String name);
}
