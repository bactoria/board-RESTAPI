package me.bactoria.boardProject.boards.dto;

import lombok.*;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class SaveRequestBoardDto {
    private String title;
    private String content;
}
