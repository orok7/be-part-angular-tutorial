package eins.angular.learning.exception;

public class NotFoundException extends RuntimeException {

    private Integer id;

    public NotFoundException(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return "Hero with id: " + id + " not found";
    }
}
