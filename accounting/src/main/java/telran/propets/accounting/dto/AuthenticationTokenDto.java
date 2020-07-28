package telran.propets.accounting.dto;

public class AuthenticationTokenDto {
    boolean status;
    String message;
    String token;

    public AuthenticationTokenDto(boolean status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
