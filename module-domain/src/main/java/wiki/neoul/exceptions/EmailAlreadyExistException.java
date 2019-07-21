package wiki.neoul.exceptions;

/**
 * Email already exists in database!
 */
public class EmailAlreadyExistException extends Exception {

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
