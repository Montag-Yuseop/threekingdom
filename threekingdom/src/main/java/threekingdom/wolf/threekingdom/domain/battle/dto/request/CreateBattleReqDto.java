package threekingdom.wolf.threekingdom.domain.battle.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateBattleReqDto {

    private Long myDeckId;
    private Long enemyDeckId;
    private Boolean isWin;

}
