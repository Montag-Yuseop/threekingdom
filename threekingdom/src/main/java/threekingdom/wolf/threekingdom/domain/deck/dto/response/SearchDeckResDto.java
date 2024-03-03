package threekingdom.wolf.threekingdom.domain.deck.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.hero.dto.response.HeroResDto;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SearchDeckResDto {

    private Long deckId;
    private List<HeroResDto> heroResDtoList = new ArrayList<>();

    public static SearchDeckResDto of(Long deckId, List<HeroResDto> heroResDtoList) {
        return SearchDeckResDto.builder()
                .deckId(deckId)
                .heroResDtoList(heroResDtoList)
                .build();
    }
}
