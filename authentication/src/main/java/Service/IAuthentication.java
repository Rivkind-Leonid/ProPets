package Service;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface IAuthentication extends Serializable {
    Boolean validateToken(String token);
    String refreshToken(String token);
    String generateToken(String email);
    Boolean validateEmail(String email);
}
