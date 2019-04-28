package me.bactoria.boardProject.boards.config;

import me.bactoria.boardProject.boards.BoardService;
import me.bactoria.boardProject.boards.dto.SaveRequestBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.stream.IntStream.rangeClosed;

@Configuration
public class AppConfig {

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Autowired
            BoardService boardService;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                rangeClosed(1, 3)
                        .mapToObj(i -> SaveRequestBoardDto.builder()
                                .title("제목" + i)
                                .content("내용" + i)
                                .build())
                        .forEach(boardService::saveBoard);
            }
        };
    }
}
