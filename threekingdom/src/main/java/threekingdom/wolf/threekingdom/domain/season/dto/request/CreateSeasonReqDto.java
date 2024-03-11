package threekingdom.wolf.threekingdom.domain.season.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateSeasonReqDto {

    @NotNull
    private int seasonNum;

    @NotNull
    private String nickname;
}
