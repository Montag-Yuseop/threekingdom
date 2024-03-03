package threekingdom.wolf.threekingdom.domain.item.entity;

import jakarta.persistence.*;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;
import threekingdom.wolf.threekingdom.domain.item.dto.reqeust.ModifyItemReqDto;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemSkill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id")
    private Hero hero;

    public static Item from(Hero hero, String itemSkill) {
        return Item.builder()
                .hero(hero)
                .itemSkill(itemSkill)
                .build();
    }

    public void update(ModifyItemReqDto modifyItemReqDto) {
        this.itemSkill = modifyItemReqDto.getItemSkill();
    }
}
