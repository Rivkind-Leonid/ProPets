package telran.ProPets.authentication.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationImpl implements IAuthentication{
    @Override
    public Boolean validateToken(String token) {
        return null;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public String generateToken(String password, String email, LocalDateTime creationTime) {

        return null;
    }

    @Override
    public Boolean validateEmail(String email) {
        return false;
    }
}
