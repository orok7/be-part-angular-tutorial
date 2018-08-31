package eins.angular.learning.exception;

public class IllegalIdException extends RuntimeException {
    public IllegalIdException() {
        super("Id cannot be null or less than '1'");
    }
}
