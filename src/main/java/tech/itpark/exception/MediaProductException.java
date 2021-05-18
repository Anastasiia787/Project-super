package tech.itpark.exception;

public class MediaProductException extends RuntimeException{
    public MediaProductException() {
        super();
    }

    public MediaProductException(String message) {
        super(message);
    }

    public MediaProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public MediaProductException(Throwable cause) {
        super(cause);
    }

    protected MediaProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
