package threekingdom.wolf.threekingdom.domain.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.battle.entity.Battle;

public interface BattleRepository extends JpaRepository<Battle, Long> {
}
