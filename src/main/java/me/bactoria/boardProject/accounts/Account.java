package me.bactoria.boardProject.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@Entity @NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id
    private String id;

    private String password;
    private String name;
    private String phone;
}
