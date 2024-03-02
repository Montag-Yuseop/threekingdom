package threekingdom.wolf.threekingdom.domain.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.user.entity.User;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findAllByUserOrderBySeasonNumAsc(User user);

}
