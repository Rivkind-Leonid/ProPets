package telran.ProPets.accounting.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private HttpStatus status;
    private String message;

    public ExceptionResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
