package threekingdom.wolf.threekingdom.domain.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.battle.entity.Battle;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;

import java.util.Optional;

public interface BattleRepository extends JpaRepository<Battle, Long> {

    Optional<Battle> findByMyDeckAndEnemyDeck(Deck myDeck, Deck enemyDeck);

}
