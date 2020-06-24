package telran.ProPets.accounting.Service;

import telran.ProPets.accounting.Dto.AccountDto;
import telran.ProPets.accounting.Dto.UsersReturnCode;
import telran.ProPets.accounting.beans.UserProfile;

import java.io.Serializable;
import java.util.List;

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
