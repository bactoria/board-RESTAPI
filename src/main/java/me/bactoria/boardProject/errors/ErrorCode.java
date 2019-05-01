package me.bactoria.boardProject.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BOARD_NOT_FOUND("B001", "해당 board가 존재하지 않습니다.",404),
    FORBIDDEN("B002", "해당 유저가 권한이 없습니다.",403);

    private final String code;
    private final String message;
    private final Integer status;

    ErrorCode(String code, String message, Integer status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
