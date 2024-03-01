package threekingdom.wolf.threekingdom.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threekingdom.wolf.threekingdom.domain.user.dto.request.UserCreateReqDto;
import threekingdom.wolf.threekingdom.domain.user.dto.request.UserSearchReqDto;
import threekingdom.wolf.threekingdom.domain.user.dto.response.UserSearchResDto;
import threekingdom.wolf.threekingdom.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody UserCreateReqDto userCreateReqDto) {

        String result = userService.join(userCreateReqDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/search")
    public ResponseEntity<UserSearchResDto> search(@Valid @RequestBody UserSearchReqDto userSearchReqDto) {

        String nickname = userSearchReqDto.getNickname();
        UserSearchResDto result = userService.search(nickname);
        log.info("검색된 닉네임 = {}", nickname);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
