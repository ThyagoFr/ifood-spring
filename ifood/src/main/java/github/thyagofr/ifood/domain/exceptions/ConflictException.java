package github.thyagofr.ifood.domain.exceptions;

public class ConflictException extends RuntimeException {

    private String message;

    public ConflictException(String message) {
        super(message);
    }
    
}
