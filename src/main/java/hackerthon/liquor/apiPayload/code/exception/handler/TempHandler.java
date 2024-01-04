package hackerthon.liquor.apiPayload.code.exception.handler;


import hackerthon.liquor.apiPayload.code.BaseErrorCode;
import hackerthon.liquor.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}