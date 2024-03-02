package threekingdom.wolf.threekingdom.domain.season.entity;

import jakarta.persistence.*;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.user.entity.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seasonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int seasonNum;

    private String seasonName;

    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    private List<Deck> decks = new ArrayList<>();

    public static Season from(User user, int seasonNum, String seasonName) {
        return Season.builder()
                .user(user)
                .seasonNum(seasonNum)
                .seasonName(seasonName)
                .build();
    }
}