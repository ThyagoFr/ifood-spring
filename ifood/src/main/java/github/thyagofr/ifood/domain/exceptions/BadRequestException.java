package github.thyagofr.ifood.domain.exceptions;

public class BadRequestException extends RuntimeException{
    private String message;

    public BadRequestException(String message) {
        super(message);
    }
}
