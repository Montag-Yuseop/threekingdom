package threekingdom.wolf.threekingdom.domain.deck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {

    List<Deck> findAllBySeason(Season season);
}
