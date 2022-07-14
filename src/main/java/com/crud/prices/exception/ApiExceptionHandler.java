package com.crud.prices.exception;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.prices.util.StandarizedApiExceptionResponse;


/**
 *
 * @author Carlos Zevallos
 * Error estándar HTTP
 * 100-level (Informational) — Server acknowledges a request, it mean that request was received and understood, it is transient response , alert client for awaiting response
 * 200-level (Success) — Server completed the request as expected
 * 300-level (Redirection) — Client needs to perform further actions to complete the request
 * 400-level (Client error) — Client sent an invalid request
 * 500-level (Server error) — Server failed to fulfill a valid request due to an error with server
 * 
 */

@RestControllerAdvice
public class ApiExceptionHandler {   
    
    //Permite definir un método para manejar esta excepción en particular de manera transversal
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBusinessRuleExceptions(BusinessRuleException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error de Validación",ex.getCode(), ex.getMessage());      
       return new ResponseEntity<>(response,  ex.getHttpStatus() != null ? ex.getHttpStatus() : HttpStatus.PARTIAL_CONTENT);
     
    }  
    
    @ExceptionHandler(IOException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleNoContentException(IOException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Input Ouput Error","Error-1",ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandarizedApiExceptionResponse> exception(Exception ex) {
		 StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Input Ouput Error","Error-2",ex.getMessage());
	        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);    
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> runtimeException(RuntimeException e) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error en Formato de JSON","Error-3",e.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
	}
    
}
