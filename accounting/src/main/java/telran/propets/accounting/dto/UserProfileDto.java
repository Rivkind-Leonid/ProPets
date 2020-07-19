package telran.propets.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserProfileDto {
    @JsonProperty
    String userEmail;
    @JsonProperty
    String name;
    @JsonProperty
    String password;
    @JsonProperty
    String phone;
    @JsonProperty
    String userPhoto;
    @JsonProperty
    LocalDate activationDate;

    public UserProfileDto(String userEmail, String name, String password, String phone, String userPhoto, LocalDate activationDate) {
        this.userEmail = userEmail;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.userPhoto = userPhoto;
        this.activationDate = activationDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public String getPassword() {
        return password;
    }



    public String getPhone() {
        return phone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }


}
