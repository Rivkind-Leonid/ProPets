package telran.ProPets.accounting.dao;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserProfile {

    @Id
    String userEmail;
    String name;
    String hashPassword;
    LocalDate activationDate;
    Boolean revoked;
    String phone;
    String userPhoto;
    Set<Enum> roles;
//    List<String> activities;
//    List<String> favorites;


    public UserProfile(String userEmail, String name, String hashPassword, LocalDate activationDate) {
        this.userEmail = userEmail;
        this.name = name;
        this.hashPassword = hashPassword;
        this.activationDate = activationDate;
        this.roles = new HashSet<>();
        roles.add(Roles.USER);
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
        return activationDate;
    }

    public Boolean getRevoked() {
        return revoked;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public Set<Enum> getRoles() {
        return roles;
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

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void addRole(Enum role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userEmail='" + userEmail + '\'' +
                ", name='" + name + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", activationDate=" + activationDate +
                ", revoked=" + revoked +
                ", phone='" + phone + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(name, that.name) &&
                Objects.equals(hashPassword, that.hashPassword) &&
                Objects.equals(activationDate, that.activationDate) &&
                Objects.equals(revoked, that.revoked) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(userPhoto, that.userPhoto) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, name, hashPassword, activationDate, revoked, phone, userPhoto, roles);
    }
}


