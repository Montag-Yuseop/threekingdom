package threekingdom.wolf.threekingdom.domain.skill.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;

@Entity
@Builder
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
}
