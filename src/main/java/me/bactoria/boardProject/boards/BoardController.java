package me.bactoria.boardProject.boards;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.boards.dto.SaveRequestBoardDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/boards", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity saveBoard(@RequestBody SaveRequestBoardDto saveRequestBoardDto) {
        Board savedBoard = boardService.saveBoard(saveRequestBoardDto);
        URI createdUri = linkTo(BoardController.class).slash(savedBoard.getId()).toUri();
        return ResponseEntity.created(createdUri).build();
    }
}
