package me.bactoria.boardProject.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BOARD_NOT_FOUND("B001", "해당 board가 존재하지 않습니다.",404);

    private final String code;
    private final String message;
    private final Integer status;

    ErrorCode(String code, String message, Integer status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
