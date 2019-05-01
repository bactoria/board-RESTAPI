package me.bactoria.boardProject.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class SaveRequestAccountDto {

    @Email(message = "이메일 형식이어야 함")
    private String email;

    @Size(min = 4, max = 20, message = "비밀번호는 4글자 이상, 20글자 이하")
    private String password;

    @NotBlank(message = "이름이 비어있음")
    private String name;

    @NotBlank(message = "휴대폰 번호가 비어있음")
    private String phone;
}
