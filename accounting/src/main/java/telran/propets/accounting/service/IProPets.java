package telran.propets.accounting.service;

import telran.propets.accounting.dto.AccountDto;
import telran.propets.accounting.dto.LoginDto;
import telran.propets.exceptions.ProPetsAccountException;
import telran.propets.exceptions.UsersReturnCode;
import telran.propets.accounting.dao.UserProfile;

import java.io.Serializable;

public interface IProPets extends Serializable {

    UsersReturnCode addUser(AccountDto accountDto) throws ProPetsAccountException;
    String logIn(LoginDto loginDto) throws ProPetsAccountException;
    UserProfile getUser(String email, String token) throws ProPetsAccountException;
    UserProfile updateUser(UserProfile profile, String token) throws ProPetsAccountException;
    UsersReturnCode deleteUser(String email, String token) throws ProPetsAccountException;



//    UsersReturnCode addUserFavorites(String postId);
//    List<String> getUserFavorites(String email);
//    List<String> deleteUserFavorites(String postId);
//    UsersReturnCode addUserActivities(String postId);
//    List<String> getUserActivities(String email);
//    UsersReturnCode deleteUserActivities(String postId);






}
