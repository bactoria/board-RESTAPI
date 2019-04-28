package me.bactoria.boardProject.boards;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
