package threekingdom.wolf.threekingdom.domain.deck.entity;

import jakarta.persistence.*;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.battle.entity.Battle;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Deck {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deckId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "myDeck", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Battle> myBattle;

    @OneToMany(mappedBy = "enemyDeck", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Battle> enemyBattle;

    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Hero> heroes = new ArrayList<>();

    public static Deck from(Season season) {
        return Deck.builder()
                .season(season)
                .build();
    }

}
