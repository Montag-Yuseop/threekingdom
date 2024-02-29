package threekingdom.wolf.threekingdom.global.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    ALREADY_WITHDRAWAL_MEMBER(HttpStatus.UNAUTHORIZED, "001", "탈퇴한 회원입니다."),
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
