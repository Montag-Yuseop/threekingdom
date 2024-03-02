package threekingdom.wolf.threekingdom.domain.item.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemResDto {

    private String itemSkill;

    public static ItemResDto of(String itemSkill) {
        return ItemResDto.builder()
                .itemSkill(itemSkill)
                .build();
    }
}
