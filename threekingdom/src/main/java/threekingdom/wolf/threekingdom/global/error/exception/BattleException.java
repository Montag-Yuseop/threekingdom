package threekingdom.wolf.threekingdom.global.error.exception;

import threekingdom.wolf.threekingdom.global.error.ErrorCode;

public class BattleException extends BaseException {
    public BattleException(ErrorCode errorCode) {
        super(errorCode);
    }
}
