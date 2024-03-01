package threekingdom.wolf.threekingdom.domain.user.service;

import threekingdom.wolf.threekingdom.domain.user.dto.request.UserCreateReqDto;
import threekingdom.wolf.threekingdom.domain.user.dto.response.UserSearchResDto;

public interface UserService {

    String join(UserCreateReqDto userCreateReqDto);

    UserSearchResDto search(String nickname);
}
