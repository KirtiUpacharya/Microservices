package com.devmind.product_service.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler(ArithmeticException.class)
    public String arithMatic(ArithmeticException ex, HttpServletRequest req)
    {
        return  ex.getMessage();
    }


}
