package threekingdom.wolf.threekingdom.domain.hero.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.item.dto.reqeust.CreateItemReqDto;
import threekingdom.wolf.threekingdom.domain.skill.dto.request.CreateSkillReqDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateHeroReqDto {

    @NotNull
    private String heroName;

    private int heroUpgrade;

    private int heroLevel;

    private List<CreateItemReqDto> itemList = new ArrayList<>();

    private List<CreateSkillReqDto> skillList = new ArrayList<>();

}
