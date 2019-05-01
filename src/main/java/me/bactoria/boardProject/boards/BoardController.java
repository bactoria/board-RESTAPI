package me.bactoria.boardProject.boards;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.accounts.Account;
import me.bactoria.boardProject.boards.dto.SaveRequestBoardDto;
import me.bactoria.boardProject.boards.dto.UpdateRequestBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/boards", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity saveBoard(@RequestBody SaveRequestBoardDto saveRequestBoardDto,
                                    @AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account") Account currentUser) {
        Board savedBoard = boardService.saveBoard(saveRequestBoardDto, currentUser);
        URI createdUri = linkTo(BoardController.class).slash(savedBoard.getId()).toUri();
        return ResponseEntity.created(createdUri).build();
    }

    @GetMapping
    public ResponseEntity getBoards(Pageable pageable) {
        Page<Board> page = boardService.getBoards(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBoard(@PathVariable Long id) {
        Board board = boardService.getBoard(id);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBoard(@PathVariable Long id,
                                      @RequestBody UpdateRequestBoardDto updateRequestBoardDto,
                                      @AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account") Account currentUser) {
        Board board = boardService.updateBoard(id, updateRequestBoardDto, currentUser);
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id,
                                      @AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account") Account currentUser) {
        boardService.deleteBoard(id, currentUser);
        return ResponseEntity.noContent().build();
    }
}
