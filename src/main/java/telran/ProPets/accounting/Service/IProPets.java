package telran.ProPets.accounting.Service;

import telran.ProPets.accounting.Dto.AccountDto;
import telran.ProPets.accounting.Dto.UsersReturnCode;

import java.io.Serializable;

public interface IProPets extends Serializable {
    UsersReturnCode addUser(AccountDto accountDto);
    
}
