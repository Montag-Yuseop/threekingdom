package threekingdom.wolf.threekingdom.domain.battle.entity;

import jakarta.persistence.*;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Battle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long battleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_deck_id")
    private Deck myDeck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy_deck_id")
    private Deck enemyDeck;

    private int battleCount;

    private int winCount;


}
