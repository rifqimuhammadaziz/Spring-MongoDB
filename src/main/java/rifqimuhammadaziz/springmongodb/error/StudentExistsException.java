package rifqimuhammadaziz.springmongodb.error;

public class StudentExistsException extends Exception {

    public StudentExistsException() {
    }

    public StudentExistsException(String message) {
        super(message);
    }

    public StudentExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentExistsException(Throwable cause) {
        super(cause);
    }

    public StudentExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
