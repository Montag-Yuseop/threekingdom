package threekingdom.wolf.threekingdom.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ALREADY_WITHDRAWAL_USER(HttpStatus.UNAUTHORIZED, "001", "탈퇴한 회원입니다."),
    ALREADY_EXIST_USER(HttpStatus.CONFLICT, "002", "이미 존재하는 닉네임입니다."),
    NO_SEARCH_USERS(HttpStatus.NO_CONTENT, "003", "검색된 유저가 없습니다."),
    ;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
}
