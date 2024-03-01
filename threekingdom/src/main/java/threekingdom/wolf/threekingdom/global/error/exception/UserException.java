package threekingdom.wolf.threekingdom.global.error.exception;

import threekingdom.wolf.threekingdom.global.error.ErrorCode;

public class UserException extends BaseException {
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
