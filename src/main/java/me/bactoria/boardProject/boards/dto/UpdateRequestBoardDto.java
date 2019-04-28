package me.bactoria.boardProject.boards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class UpdateRequestBoardDto {
    private String title;
    private String content;
}
