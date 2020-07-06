package telran.ProPets.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.LoginDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.dao.UserProfile;
import telran.ProPets.accounting.exceptions.ProPetsAccountException;
import telran.ProPets.accounting.repo.AccountRepository;
import telran.ProPets.authentication.Service.IAuthentication;

import javax.security.auth.login.AccountException;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class ProPetsImpl implements IProPets {
    @Autowired
    AccountRepository repository;
    @Autowired
    IAuthentication authentication;

    @Override
    public UsersReturnCode addUser(AccountDto accountDto) {
        String email = accountDto.getUserEmail();
        if(repository.existsById(email)){
            return UsersReturnCode.EMAIL_ALREADY_EXISTS;
        }
        String password = accountDto.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String name = accountDto.getName();
        repository.save(new UserProfile(email, name, hashPassword, LocalDate.now()));
        return UsersReturnCode.OK;
    }

    @Override
    public String logIn(LoginDto loginDto) throws ProPetsAccountException {
        String email = loginDto.getEmail();
        if(!repository.existsById(email)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.EMAIL_NOT_EXISTS.name());
        }
        String password = loginDto.getPassword();
        String hashPassword = repository.findById(email).get().getHashPassword();
        if(!BCrypt.checkpw(password, hashPassword)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.INVALID_PASSWORD.name());
        }
        String token = authentication.generateToken(password, email, LocalDateTime.now());
        return token;
    }

    @Override
    public UserProfile getUser(String email, String token) {
        if(!authentication.validateToken(token)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        if(!authentication.validateEmail(email)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.INVALID_EMAIL.name());
        }
        return repository.findById(email).get();
    }

    @Override
    public UserProfile updateUser(UserProfile user) {
        return null;
    }

    @Override
    public UsersReturnCode deleteUser(String email) {
        return null;
    }

}
