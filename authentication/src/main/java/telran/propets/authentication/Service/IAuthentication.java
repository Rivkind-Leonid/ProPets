package telran.propets.authentication.Service;

import telran.propets.authentication.AuthResponse.AuthResponse;

import java.io.Serializable;

public interface IAuthentication extends Serializable {
    AuthResponse validateToken(String token);
    String refreshToken(String token);
    String generateToken(String email);
    Boolean validateEmail(String email, String token);
}
