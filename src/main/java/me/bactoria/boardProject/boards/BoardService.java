package me.bactoria.boardProject.boards;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.boards.dto.SaveRequestBoardDto;
import me.bactoria.boardProject.boards.dto.UpdateRequestBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board saveBoard(SaveRequestBoardDto saveRequestBoardDto) {
        String title = saveRequestBoardDto.getTitle();
        String content = saveRequestBoardDto.getContent();
        LocalDateTime createdTime = LocalDateTime.now();

        Board board = Board.builder()
                .title(title)
                .content(content)
                .createdTime(createdTime)
                .build();

        return boardRepository.save(board);
    }

    public Page<Board> getBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Board updateBoard(Long id, UpdateRequestBoardDto updateRequestBoardDto) {
        String title = updateRequestBoardDto.getTitle();
        String content = updateRequestBoardDto.getContent();

        Board board = boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        board.setTitle(title);
        board.setContent(content);

        return boardRepository.save(board);
    }
}
