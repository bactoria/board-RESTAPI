package me.bactoria.boardProject.accounts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestAccountDto {
    private String password;
    private String name;
    private String phone;
}
