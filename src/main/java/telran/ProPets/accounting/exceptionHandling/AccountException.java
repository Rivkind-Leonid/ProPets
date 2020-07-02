package telran.ProPets.accounting.exceptionHandling;

import org.springframework.http.HttpStatus;

public class AccountException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
