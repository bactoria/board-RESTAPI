package me.bactoria.boardProject.errors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private final String code;
    private final String message;
    private final Integer status;

    static ErrorResponse fromErrorCode(ErrorCode errorCode) {
        Integer status = errorCode.getStatus();
        String code = errorCode.getCode();
        String message = errorCode.getMessage();
        return new ErrorResponse(code, message, status);
    }

}
