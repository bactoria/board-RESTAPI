package me.bactoria.boardProject.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class SaveRequestAccountDto {
    private String id;
    private String password;
    private String name;
    private String phone;
}
