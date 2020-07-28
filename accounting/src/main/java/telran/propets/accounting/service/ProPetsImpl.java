package telran.propets.accounting.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import telran.propets.accounting.api.ApiConstants;
import telran.propets.accounting.dto.*;
import org.springframework.stereotype.Service;
import telran.propets.exceptions.UsersReturnCode;
import telran.propets.accounting.repo.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import telran.propets.accounting.dao.UserProfile;
import telran.propets.exceptions.ProPetsAccountException;


import java.time.LocalDate;


@Service
public class ProPetsImpl implements IProPets {
    @Autowired
    AccountRepository repository;
    String baseUrl = "http://localhost:8080/";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    @Override
    public UsersReturnCode addUser(AccountDto accountDto) throws ProPetsAccountException {
        String email = accountDto.getUserEmail();
        if(repository.existsById(email)){
            throw new ProPetsAccountException(HttpStatus.BAD_REQUEST, UsersReturnCode.EMAIL_ALREADY_EXISTS.name());
        }
        String password = accountDto.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String name = accountDto.getName();
        repository.save(new UserProfile(email, name, hashPassword, LocalDate.now()));
        return UsersReturnCode.OK;
    }

    @Override
    public String logIn(LoginDto loginDto) {
        String email = loginDto.getEmail();
        if(!repository.existsById(email)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.EMAIL_NOT_EXISTS.name());
        }
        String password = loginDto.getPassword();
        String hashPassword = repository.findById(email).get().getHashPassword();
        if(!BCrypt.checkpw(password, hashPassword)){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.INVALID_PASSWORD.name());
        }
        HttpEntity request = new HttpEntity<>();
        ResponseEntity<AuthenticationTokenDto> response = restTemplate
                .exchange(baseUrl + ApiConstants.GENERATE_TOKEN + email + "/", HttpMethod.GET, request, AuthenticationTokenDto.class);
        if(response.getStatusCodeValue()!= 200 ||!response.getBody().getStatus()){
            throw new ProPetsAccountException(HttpStatus.INTERNAL_SERVER_ERROR, UsersReturnCode.LOG_IN_FAILED.name());
        }
        return response.getBody().getToken();
    }

    @Override
    public UserProfile getUser(String email, String token) {
        if(!repository.existsById(email)) {
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.EMAIL_NOT_EXISTS.name());
        }
        HttpEntity request = new HttpEntity<>();
        request.getHeaders().add("Authorization", token);
        ResponseEntity<AuthenticationDto> response = restTemplate
                .exchange(baseUrl + ApiConstants.VALIDATE_TOKEN + email + "/", HttpMethod.GET, request, AuthenticationDto.class);

        if(response.getStatusCodeValue()!= 200 ||!response.getBody().getStatus()){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        return repository.findById(email).get();
    }

    @Override
    public UserProfile updateUser(UserProfileDto user, String token) {
        if(!repository.existsById(user.getUserEmail())) {
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.EMAIL_NOT_EXISTS.name());
        }
        HttpEntity request = new HttpEntity<>();
        request.getHeaders().add("Authorization", token);
        ResponseEntity<AuthenticationDto> response = restTemplate
                .exchange(baseUrl + ApiConstants.VALIDATE_TOKEN, HttpMethod.GET, request, AuthenticationDto.class);
        if(response.getStatusCodeValue()!= 200 ||!response.getBody().getStatus()) {
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        UserProfile updatedUser = new UserProfile(user.getUserEmail(), user.getName(), hashPassword, user.getActivationDate());
        return repository.save(updatedUser);
    }

    @Override
    public UsersReturnCode deleteUser(String email, String token) {
        if(!repository.existsById(email)) {
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.EMAIL_NOT_EXISTS.name());
        }
        HttpEntity request = new HttpEntity<>();
        request.getHeaders().add("Authorization", token);
        ResponseEntity<AuthenticationDto> response = restTemplate
                .exchange(baseUrl + ApiConstants.VALIDATE_TOKEN + email + "/", HttpMethod.GET, request, AuthenticationDto.class);
        if(response.getStatusCodeValue()!= 200 ||!response.getBody().getStatus()){
            throw new ProPetsAccountException(HttpStatus.UNAUTHORIZED, UsersReturnCode.NEED_TO_SIGN_IN.name());
        }
        repository.delete(repository.findById(email).get());
        return UsersReturnCode.OK;
    }

}
