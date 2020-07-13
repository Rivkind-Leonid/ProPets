package telran.propets.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ProPetsAccountException.class)
    @ResponseBody
    public ExceptionResponse accountExceptionHandler (HttpServletResponse response, ProPetsAccountException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getStatus(), e.getMessage());
        response.setStatus(e.getStatus().value());
        return exceptionResponse;
    }
}
