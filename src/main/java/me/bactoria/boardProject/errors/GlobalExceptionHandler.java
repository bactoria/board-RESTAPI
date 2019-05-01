package me.bactoria.boardProject.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity handleEntityNotFoundException(EntityNotFoundException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorResponse response = ErrorResponse.fromErrorCode(ErrorCode.BOARD_NOT_FOUND);
        return new ResponseEntity(response, HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(UserDeniedAuthorizationException.class)
    protected ResponseEntity handleUserDeniedAuthorizationException(UserDeniedAuthorizationException e) {
        log.error("handleUserDeniedAuthorizationException", e);
        final ErrorResponse response = ErrorResponse.fromErrorCode(ErrorCode.FORBIDDEN);
        return new ResponseEntity(response, HttpStatus.valueOf(response.getStatus()));
    }
}
