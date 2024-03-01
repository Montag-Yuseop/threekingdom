package threekingdom.wolf.threekingdom.domain.user.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.user.entity.User;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserListDto {

    private Long userId;

    private String nickname;

    public static UserListDto from(User user) {
        return UserListDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .build();
    }

}
