package me.bactoria.boardProject.errors.exceptions;

public class AccountAlreadyExistException extends RuntimeException{
    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
