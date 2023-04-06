package pl.danceclub.app.domain.unit;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {
    List<Unit> findAllByPromotedIsTrue();
    List<Unit> findAllByGenre_Name(String name);
    @Query("select u from Unit u join u.ratings r group by u order by avg(r.unit_rate) desc")
    List<Unit> findTopByRating(Pageable page);
}
