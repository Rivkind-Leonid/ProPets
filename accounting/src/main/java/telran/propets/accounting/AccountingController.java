package telran.propets.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import telran.propets.accounting.api.ApiConstants;
import telran.propets.accounting.dao.UserProfile;
import telran.propets.accounting.dto.AccountDto;
import telran.propets.accounting.dto.LoginDto;
import telran.propets.exceptions.UsersReturnCode;
import telran.ProPets.exceptions.ProPetsAccountException;
import telran.propets.accounting.service.IProPets;
import telran.propets.accounting.repo.AccountRepository;
import telran.ProPets.authentication.Service.IAuthentication;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountingController {
    IProPets proPets;
    @Autowired
    AccountRepository repository;
    @Autowired
    IAuthentication authentication;

    @PostMapping(value = ApiConstants.ADD_USER)
    public UsersReturnCode addUser (@RequestBody AccountDto accountDto){
        return proPets.addUser(accountDto);
    }

    @GetMapping(value = ApiConstants.LOG_IN)
    public String login(@RequestBody LoginDto loginDto){
        return proPets.logIn(loginDto);
    }

    @GetMapping(value = ApiConstants.USER + "{email}")
    public UserProfile getUser(@PathVariable("email") String email, HttpServletRequest request){
        String token = request.getHeader("authorization");
        if(!authentication.validateToken(token)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        return proPets.getUser(email);
    }

    @GetMapping(value = ApiConstants.USER + "{email}")
    public UsersReturnCode deleteUser(@PathVariable("email") String email, HttpServletRequest request){
        String token = request.getHeader("authorization");
        if(!authentication.validateToken(token)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        return proPets.deleteUser(email);
    }
}
