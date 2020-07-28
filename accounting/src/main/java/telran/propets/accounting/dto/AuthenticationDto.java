package telran.propets.accounting.dto;

public class AuthenticationDto {
    boolean status;
    String message;

    public AuthenticationDto(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
