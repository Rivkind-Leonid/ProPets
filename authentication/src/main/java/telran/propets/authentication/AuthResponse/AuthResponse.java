package telran.propets.authentication.AuthResponse;

public class AuthResponse {
    boolean status;
    String message;

    public AuthResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
