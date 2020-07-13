package Service;

import java.io.Serializable;

public interface IAuthentication extends Serializable {
    Boolean validateToken(String token);
    String refreshToken(String token);
    String generateToken(String email);
    Boolean validateEmail(String email);
}
