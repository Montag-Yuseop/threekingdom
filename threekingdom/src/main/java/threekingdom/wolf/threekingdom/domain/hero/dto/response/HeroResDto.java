package threekingdom.wolf.threekingdom.domain.hero.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.item.dto.response.ItemResDto;
import threekingdom.wolf.threekingdom.domain.skill.dto.response.SkillResDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HeroResDto {

    private Long heroId;
    private String heroName;
    private int heroLevel;
    private int heroUpgrade;
    private List<ItemResDto> itemResDtoList = new ArrayList<>();
    private List<SkillResDto> skillResDtoList = new ArrayList<>();

    public static HeroResDto of(Long heroId, String heroName, int heroLevel, int heroUpgrade, List<ItemResDto> itemResDtoList, List<SkillResDto> skillResDtoList) {
        return HeroResDto.builder()
                .heroId(heroId)
                .heroName(heroName)
                .heroLevel(heroLevel)
                .heroUpgrade(heroUpgrade)
                .itemResDtoList(itemResDtoList)
                .skillResDtoList(skillResDtoList)
                .build();
    }
}
