package telran.ProPets.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.LoginDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.dao.UserProfile;
import telran.ProPets.accounting.repo.AccountRepository;

import javax.security.auth.login.AccountException;
import java.time.LocalDate;


@Service
public class ProPetsImpl implements IProPets {
    @Autowired
    AccountRepository repository;

    @Override
    public UsersReturnCode addUser(AccountDto accountDto) {
        String email = accountDto.getUserEmail();
        if(repository.existsById(email)){
            return UsersReturnCode.E_MAIL_ALREADY_EXISTS;
        }
        String password = accountDto.getPassword();
        String salt = BCrypt.gensalt();
        String hashPassword = BCrypt.hashpw(password, salt);
        String name = accountDto.getName();
        repository.save(new UserProfile(email, name, hashPassword, LocalDate.now()));
        return UsersReturnCode.OK;
    }

    @Override
    public String logIn(LoginDto loginDto) throws AccountException {
        String email = loginDto.getEmail();
        if(!repository.existsById(email)){
            throw new AccountException();
        }


        String password = loginDto.getPassword();
        String hashPassword = repository.findById(email).get().getHashPassword();
        if(!BCrypt.checkpw(password, hashPassword)){
            return "...";
        }
        return null;
    }

    @Override
    public UserProfile getUser(String email) {

        return null;
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
