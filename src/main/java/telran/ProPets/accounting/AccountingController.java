package telran.ProPets.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.Service.IProPets;
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
}
