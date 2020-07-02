package telran.ProPets.accounting.exceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(AccountException.class)
    @ResponseBody
    public ExceptionResponse accountExceptionHandler (HttpServletResponse response, AccountException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getStatus(), e.getMessage());
        response.setStatus(e.getStatus().value());
        return exceptionResponse;
    }
}
