package threekingdom.wolf.threekingdom.domain.season.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeasonListResDto {

    @NotNull
    private List<SeasonResDto> seasonResDtos = new ArrayList<>();

    public static SeasonListResDto from (List<SeasonResDto> seasonResDtos) {
        return SeasonListResDto.builder()
                .seasonResDtos(seasonResDtos)
                .build();
    }

}
