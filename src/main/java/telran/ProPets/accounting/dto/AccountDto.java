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

    @Override
    public String toString() {
        return "AccountDto{" +
                "userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, password, name);
    }
}
