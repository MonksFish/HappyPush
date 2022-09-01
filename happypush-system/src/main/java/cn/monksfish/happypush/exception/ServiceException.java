package cn.monksfish.happypush.exception;

public class ServiceException extends RuntimeException {
    private final String errorCode;

    public ServiceException(ExceptionInterface exceptionInterface) {
        super(exceptionInterface.getExceptionMsg());
        this.errorCode = exceptionInterface.getExceptionCode();
    }

    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
