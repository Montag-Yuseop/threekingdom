package threekingdom.wolf.threekingdom.global.error.exception;

import lombok.Getter;
import threekingdom.wolf.threekingdom.global.error.ErrorCode;

@Getter
public class BaseException extends RuntimeException{

    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;

    }

}
