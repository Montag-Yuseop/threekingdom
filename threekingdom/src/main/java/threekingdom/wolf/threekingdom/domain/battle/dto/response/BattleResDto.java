package threekingdom.wolf.threekingdom.domain.battle.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BattleResDto {

    private Long battleId;
    private int battleCount;
    private int winCount;
    private double rate;

    public static BattleResDto of(Long battleId, int battleCount, int winCount, double winRate) {
        return BattleResDto.builder()
                .battleId(battleId)
                .battleCount(battleCount)
                .winCount(winCount)
                .rate(winRate)
                .build();
    }

}
