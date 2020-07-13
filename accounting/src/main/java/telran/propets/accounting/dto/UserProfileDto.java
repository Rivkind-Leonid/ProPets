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
    LocalDate activationDate;
    @JsonProperty
    Boolean revoked;
    @JsonProperty
    String phone;
    @JsonProperty
    String userPhoto;

    public UserProfileDto(String userEmail, String name, String password, LocalDate activationDate, Boolean revoked, String phone, String userPhoto) {
        this.userEmail = userEmail;
        this.name = name;
        this.password = password;
        this.activationDate = activationDate;
        this.revoked = revoked;
        this.phone = phone;
        this.userPhoto = userPhoto;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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
}
