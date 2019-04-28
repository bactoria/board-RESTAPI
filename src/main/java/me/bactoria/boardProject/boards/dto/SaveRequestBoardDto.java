package me.bactoria.boardProject.boards.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveRequestBoardDto {
    private String title;
    private String content;
}
