package threekingdom.wolf.threekingdom.domain.deck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
