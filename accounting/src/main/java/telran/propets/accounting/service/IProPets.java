package telran.propets.accounting.service;

import telran.propets.accounting.dto.AccountDto;
import telran.propets.accounting.dto.LoginDto;
import telran.propets.exceptions.UsersReturnCode;
import telran.propets.accounting.dao.UserProfile;
import telran.ProPets.exceptions.ProPetsAccountException;

import java.io.Serializable;

public interface IProPets extends Serializable {

    UsersReturnCode addUser(AccountDto accountDto);
    String logIn(LoginDto loginDto) throws ProPetsAccountException;
    UserProfile getUser(String email);
    UserProfile updateUser(UserProfile profile);
    UsersReturnCode deleteUser(String email);



//    UsersReturnCode addUserFavorites(String postId);
//    List<String> getUserFavorites(String email);
//    List<String> deleteUserFavorites(String postId);
//    UsersReturnCode addUserActivities(String postId);
//    List<String> getUserActivities(String email);
//    UsersReturnCode deleteUserActivities(String postId);






}
