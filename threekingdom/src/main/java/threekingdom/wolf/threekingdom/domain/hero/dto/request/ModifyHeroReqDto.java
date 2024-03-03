package threekingdom.wolf.threekingdom.domain.hero.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.item.dto.reqeust.ModifyItemReqDto;
import threekingdom.wolf.threekingdom.domain.skill.dto.request.ModifySkillReqDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ModifyHeroReqDto {
    private Long heroId;

    private String heroName;

    private int heroUpgrade;

    private int heroLevel;

    private List<ModifyItemReqDto> itemList = new ArrayList<>();

    private List<ModifySkillReqDto> skillList = new ArrayList<>();
}
