package threekingdom.wolf.threekingdom.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.user.dto.UserListDto;
import threekingdom.wolf.threekingdom.domain.user.dto.request.UserCreateReqDto;
import threekingdom.wolf.threekingdom.domain.user.dto.response.UserSearchResDto;
import threekingdom.wolf.threekingdom.domain.user.dto.response.UserSelectResDto;
import threekingdom.wolf.threekingdom.domain.user.entity.User;
import threekingdom.wolf.threekingdom.domain.user.repository.UserRepository;
import threekingdom.wolf.threekingdom.global.error.ErrorCode;
import threekingdom.wolf.threekingdom.global.error.exception.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public String join(UserCreateReqDto userCreateReqDto) {

        String nickname = userCreateReqDto.getNickname();

        Optional<User> findUser = userRepository.findByNickname(nickname);

        if(findUser.isPresent()) {
            // 닉네임 중복시 오류
            throw new UserException(ErrorCode.ALREADY_EXIST_USER);
        }

        User user = User.builder()
                .nickname(nickname)
                .build();

        userRepository.save(user);

        return "Success";
    }

    @Override
    public UserSearchResDto search(String nickname) {

        List<User> allByNickname = userRepository.findByNicknameContaining(nickname); // 닉네임이 포함된 유저 전체 가져오기

        if(allByNickname.isEmpty()) {
            // 검색된 유저가 없으면 에러 반환
            throw new UserException(ErrorCode.NO_SEARCH_USERS);
        }

        List<UserListDto> userListDtos = new ArrayList<>();

        for (User user : allByNickname) {
            userListDtos.add(UserListDto.from(user));
        }

        return UserSearchResDto.from(userListDtos);
    }
}
