package threekingdom.wolf.threekingdom.domain.skill.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SkillResDto {

    private Long skillId;
    private String skillName;
    private int skillLevel;

    public static SkillResDto of(Long skillId, String skillName, int skillLevel) {
        return SkillResDto.builder()
                .skillId(skillId)
                .skillName(skillName)
                .skillLevel(skillLevel)
                .build();
    }
}
