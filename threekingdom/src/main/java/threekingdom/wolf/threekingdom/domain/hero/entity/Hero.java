package threekingdom.wolf.threekingdom.domain.hero.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.hero.dto.request.ModifyHeroReqDto;
import threekingdom.wolf.threekingdom.domain.item.entity.Item;
import threekingdom.wolf.threekingdom.domain.skill.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hero {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heroId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @Column(nullable = false)
    private String heroName;

    @ColumnDefault("0")
    private int heroUpgrade;

    @Column(nullable = false)
    private int heroLevel;

    @OneToMany(mappedBy = "hero", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "hero", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Item> items = new ArrayList<>();

    public static Hero from(Deck deck, String heroName, int heroUpgrade, int heroLevel) {
        return Hero.builder()
                .deck(deck)
                .heroName(heroName)
                .heroUpgrade(heroUpgrade)
                .heroLevel(heroLevel)
                .build();
    }

    public void update(ModifyHeroReqDto modifyHeroReqDto) {
        this.heroLevel = modifyHeroReqDto.getHeroLevel();
        this.heroName = modifyHeroReqDto.getHeroName();
        this.heroUpgrade = modifyHeroReqDto.getHeroUpgrade();

    }

}
