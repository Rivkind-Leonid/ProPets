package telran.ProPets.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.ProPets.accounting.dao.UserProfile;
import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.LoginDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.service.IProPets;
import telran.ProPets.accounting.api.ApiConstants;
import telran.ProPets.accounting.repo.AccountRepository;

@RestController
public class AccountingController {
    IProPets proPets;
    @Autowired
    AccountRepository repository;

    @PostMapping(value = ApiConstants.ADD_USER)
    public UsersReturnCode addUser (@RequestBody AccountDto accountDto){
        return proPets.addUser(accountDto);
    }

    @GetMapping(value = ApiConstants.LOG_IN)
    public String login(@RequestBody LoginDto loginDto){
        return proPets.logIn(loginDto);
    }

    @GetMapping(value = ApiConstants.GET_USER + "{email}")
    public UserProfile getUser(@PathVariable("email") String email){
        return proPets.getUser(email);
    }
}
