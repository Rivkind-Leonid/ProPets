package telran.ProPets.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class AccountDto {
    @JsonProperty
    String userEmail;
    @JsonProperty
    String password;
    @JsonProperty
    String name;

    public AccountDto(String usersEmail, String password, String name) {
        this.userEmail = usersEmail;
        this.password = password;
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }




}
