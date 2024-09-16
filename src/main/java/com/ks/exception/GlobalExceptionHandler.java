package com.ks.exception;

import com.ks.domain.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public Result serviceExceptionHandler(ServiceException ex) {
        return Result.error(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public Result globalAccessDeniedExceptionHandler(AccessDeniedException ex) {
        return Result.error(403, "You do not have permission to access.");
    }
    @ExceptionHandler(value = AuthenticationException.class)
    public Result globalAuthenticationExceptionHandler(RuntimeException ex) {
        return Result.error(401,ex.getMessage());
    }
    @ExceptionHandler(value = RuntimeException.class)
    public Result globalExceptionHandler(RuntimeException ex) {
        log.error(ex.getMessage());
        return Result.error(500,ex.getMessage());
    }
}
