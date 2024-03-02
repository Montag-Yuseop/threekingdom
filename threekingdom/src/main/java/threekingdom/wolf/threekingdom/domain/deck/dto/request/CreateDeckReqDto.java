package threekingdom.wolf.threekingdom.domain.deck.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.hero.dto.request.CreateHeroReqDto;

import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateDeckReqDto {

    @NotNull
    private Long userId;

    @NotNull
    private int seasonNum;

    private List<CreateHeroReqDto> heroList = new ArrayList<>();

}
