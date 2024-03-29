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

    private Long itemId;
    private String itemSkill;

    public static ItemResDto of(Long itemId, String itemSkill) {
        return ItemResDto.builder()
                .itemId(itemId)
                .itemSkill(itemSkill)
                .build();
    }
}
