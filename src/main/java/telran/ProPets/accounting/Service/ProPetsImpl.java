package telran.ProPets.accounting.Service;

import telran.ProPets.accounting.Dto.AccountDto;
import telran.ProPets.accounting.Dto.UsersReturnCode;
import telran.ProPets.accounting.beans.UserProfile;

public class ProPetsImpl implements IProPets {
    @Override
    public UsersReturnCode addUser(AccountDto accountDto) {
        return null;
    }

    @Override
    public String logIn(String password, String email) {
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
