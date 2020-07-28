package telran.propets.accounting.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "users")
public class UserProfile {

    @Id
    String userEmail;
    String name;
    String hashPassword;
    LocalDate activationDate;
    String phone;
    String userPhoto;



    public UserProfile(String userEmail, String name, String hashPassword, LocalDate activationDate) {
        this.userEmail = userEmail;
        this.name = name;
        this.hashPassword = hashPassword;
        this.activationDate = activationDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public LocalDate getActivationDate() {
        return activationDate;}


    public String getPhone() {
        return phone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userEmail='" + userEmail + '\'' +
                ", name='" + name + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", activationDate=" + activationDate +
                ", phone='" + phone + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}


