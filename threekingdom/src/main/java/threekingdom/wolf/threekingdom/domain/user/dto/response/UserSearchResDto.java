package threekingdom.wolf.threekingdom.domain.user.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import threekingdom.wolf.threekingdom.domain.user.dto.UserListDto;
import threekingdom.wolf.threekingdom.domain.user.dto.request.UserSearchReqDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserSearchResDto {

    private List<UserListDto> userList = new ArrayList<>();

    public static UserSearchResDto from(List<UserListDto> userList) {
        return UserSearchResDto.builder()
                .userList(userList)
                .build();
    }
}
