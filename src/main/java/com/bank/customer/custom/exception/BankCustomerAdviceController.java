package com.bank.customer.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BankCustomerAdviceController extends ResponseEntityExceptionHandler {
       private static final String CUSTOMER_NOT_FOUND="CUSTOMER IS NOT FOUND IN OUR DATABASE..";

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> customerNotFoundException(CustomerNotFoundException customerNFE, WebRequest request){
                 ErrorResponse er=new ErrorResponse();
                 List<String> errors=new ArrayList<>();
                 errors.add(customerNFE.getLocalizedMessage());
                 er.setMessage(CUSTOMER_NOT_FOUND);
                 er.setErrors(errors);

                 return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                                Map<String, String> errors = new HashMap<>();
                                ex.getBindingResult().getAllErrors().forEach((error) -> {
                                                                        String fieldName = ((FieldError) error).getField();
                                                                        String errorMessage = error.getDefaultMessage();
                                                                        errors.put(fieldName, errorMessage);
                                                                                        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
