package threekingdom.wolf.threekingdom.domain.deck.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.hero.dto.request.CreateHeroReqDto;
import threekingdom.wolf.threekingdom.domain.hero.dto.request.ModifyHeroReqDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ModifyDeckReqDto {

    private List<ModifyHeroReqDto> heroList = new ArrayList<>();
}
