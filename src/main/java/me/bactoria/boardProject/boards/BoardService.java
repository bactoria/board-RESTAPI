package me.bactoria.boardProject.boards;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.boards.dto.SaveRequestBoardDto;
import org.springframework.stereotype.Service;

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
}
