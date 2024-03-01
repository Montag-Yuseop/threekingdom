package threekingdom.wolf.threekingdom.domain.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
