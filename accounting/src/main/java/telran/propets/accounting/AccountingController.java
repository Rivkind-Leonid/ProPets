package telran.propets.accounting;

import telran.propets.authentication.Service.IAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.propets.accounting.api.ApiConstants;
import telran.propets.accounting.dao.UserProfile;
import telran.propets.accounting.dto.AccountDto;
import telran.propets.accounting.dto.LoginDto;
import telran.propets.accounting.dto.UserProfileDto;
import telran.propets.exceptions.UsersReturnCode;
import telran.propets.accounting.service.IProPets;
import telran.propets.accounting.repo.AccountRepository;

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

    @PostMapping(value = ApiConstants.LOG_IN)
    public String login(@RequestBody LoginDto loginDto){
        return proPets.logIn(loginDto);
    }

    @GetMapping(value = ApiConstants.USER + "{email}")
    public UserProfile getUser(@PathVariable("email") String email, HttpServletRequest request){
        String token = request.getHeader("authorization");
        return proPets.getUser(email, token);
    }

    @PutMapping(value = ApiConstants.USER)
    public UserProfile updateUser(@RequestBody UserProfileDto userProfileDto, HttpServletRequest request){
        String token = request.getHeader("authorization");
        return proPets.updateUser(userProfileDto, token);
    }


    @DeleteMapping(value = ApiConstants.USER + "{email}")
    public UsersReturnCode deleteUser(@PathVariable("email") String email, HttpServletRequest request){
        String token = request.getHeader("authorization");

        return proPets.deleteUser(email, token);
    }
}
