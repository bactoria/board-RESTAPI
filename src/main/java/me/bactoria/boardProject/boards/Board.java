package me.bactoria.boardProject.boards;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import me.bactoria.boardProject.accounts.Account;
import me.bactoria.boardProject.accounts.AccountSerializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
public class Board {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdTime;

    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    private Account account;
}
