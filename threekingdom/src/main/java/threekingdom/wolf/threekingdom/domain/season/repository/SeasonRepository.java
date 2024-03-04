package threekingdom.wolf.threekingdom.domain.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findAllByUserOrderBySeasonNumAsc(User user);

    Optional<Season> findBySeasonNumAndUser(int seasonNum, User user);

    Optional<Season> findAllByUserAndSeasonNum(User user, int seasonNum);

}
