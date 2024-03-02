package threekingdom.wolf.threekingdom.domain.season.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeasonResDto {

    private int seasonNum;

    private String seasonName;

    public static SeasonResDto from(Season season) {
        return SeasonResDto.builder()
                .seasonNum(season.getSeasonNum())
                .seasonName(season.getSeasonName())
                .build();
    }
}
