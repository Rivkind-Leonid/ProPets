package telran.ProPets.accounting.Service;

import telran.ProPets.accounting.dto.AccountDto;
import telran.ProPets.accounting.dto.UsersReturnCode;
import telran.ProPets.accounting.dao.UserProfile;

import java.io.Serializable;

public interface IProPets extends Serializable {

    UsersReturnCode addUser(AccountDto accountDto);
    String logIn(String password,String email);
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
