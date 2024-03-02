package threekingdom.wolf.threekingdom.domain.skill.entity;

import jakarta.persistence.*;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    // 장수 아이디로 가져오기
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_level")
    private int skillLevel;

    @Column(name = "skill_info")
    private String skillInfo;

    public static Skill from(Hero hero, String skillName, int skillLevel) {
        return Skill.builder()
                .hero(hero)
                .skillName(skillName)
                .skillLevel(skillLevel)
                .build();
    }
}
