package threekingdom.wolf.threekingdom.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // User
    ALREADY_WITHDRAWAL_USER(HttpStatus.UNAUTHORIZED, "001", "탈퇴한 회원입니다."),
    ALREADY_EXIST_USER(HttpStatus.BAD_REQUEST, "002", "이미 존재하는 닉네임입니다."),
    NO_SEARCH_USERS(HttpStatus.BAD_REQUEST, "003", "검색된 유저가 없습니다."),

    // Season
    NO_EXIST_SEASON(HttpStatus.BAD_REQUEST, "001", "시즌이 없습니다."),
    ALREADY_EXIST_SEASON(HttpStatus.BAD_REQUEST, "002", "해당 유저의 시즌이 이미 존재합니다."),
    
    // Hero
    NO_EXIST_HERO(HttpStatus.BAD_REQUEST, "001", "장수가 없습니다."),

    // Deck
    NO_EXIST_DECK(HttpStatus.BAD_REQUEST, "001", "덱이 없습니다."),
    
    // Item
    NO_EXIST_ITEM(HttpStatus.BAD_REQUEST, "001", "아이템이 없습니다."),
    
    // SKill
    NO_EXIST_SKILL(HttpStatus.BAD_REQUEST, "001", "스킬이 없습니다.")
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
