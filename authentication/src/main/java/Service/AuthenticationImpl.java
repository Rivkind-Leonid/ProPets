package Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import telran.propets.exceptions.ProPetsAuthenticationException;
import telran.propets.exceptions.UsersReturnCode;

import java.util.Date;

@Service
public class AuthenticationImpl implements IAuthentication {
    private String secret = "ProPets";
    @Override
    public Boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            jwt.getClaims().forEach((k, v) -> System.out.println(k + " " +  v.asString() + "\n"));
        } catch (JWTVerificationException exception){
            return false;
        }
        return true;
    }

    @Override
    public String refreshToken(String token) {

        return null;
    }

    @Override
    public String generateToken(String email) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withClaim("email", email)
                    .withExpiresAt(new Date(new Date().getTime() + 5000L))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new ProPetsAuthenticationException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }

        return token;
    }

    @Override
    public Boolean validateEmail(String email) {
        return false;
    }
}
