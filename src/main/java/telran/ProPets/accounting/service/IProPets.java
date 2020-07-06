package telran.ProPets.accounting.service;

import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.LoginDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.dao.UserProfile;
import telran.ProPets.accounting.exceptions.ProPetsAccountException;

import javax.security.auth.login.AccountException;
import java.io.Serializable;

public interface IProPets extends Serializable {

    UsersReturnCode addUser(AccountDto accountDto);
    String logIn(LoginDto loginDto) throws ProPetsAccountException;
    UserProfile getUser(String email, String token);
    UserProfile updateUser(UserProfile profile);
    UsersReturnCode deleteUser(String email);



//    UsersReturnCode addUserFavorites(String postId);
//    List<String> getUserFavorites(String email);
//    List<String> deleteUserFavorites(String postId);
//    UsersReturnCode addUserActivities(String postId);
//    List<String> getUserActivities(String email);
//    UsersReturnCode deleteUserActivities(String postId);






}
