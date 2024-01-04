package hackerthon.liquor.apiPayload.code;

public interface BaseErrorCode {

    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
