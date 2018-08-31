package eins.angular.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleBaseExceptions(Throwable e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // It could be deleted because of the same logic as in handleBaseExceptions method
    // bu this is for learning
    @ExceptionHandler({IllegalIdException.class})
    public ResponseEntity<String> handleIllegalIdException(IllegalIdException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // It could be deleted because of the same logic as in handleBaseExceptions method
    // bu this is for learning
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
