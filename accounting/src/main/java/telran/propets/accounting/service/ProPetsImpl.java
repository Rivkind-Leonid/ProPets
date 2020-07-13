package telran.propets.accounting.service;

import Service.IAuthentication;
import org.springframework.stereotype.Service;
import telran.propets.accounting.dto.LoginDto;
import telran.propets.exceptions.UsersReturnCode;
import telran.propets.accounting.repo.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import telran.propets.accounting.dto.AccountDto;
import telran.propets.accounting.dao.UserProfile;
import telran.propets.exceptions.ProPetsAccountException;


import java.time.LocalDate;


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
        String token = authentication.generateToken(email);
        return token;
    }

    @Override
    public UserProfile getUser(String email) {

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
        if(!authentication.validateEmail(email)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.INVALID_EMAIL.name());
        }
        repository.delete(repository.findById(email).get());
        return UsersReturnCode.OK;
    }

}
