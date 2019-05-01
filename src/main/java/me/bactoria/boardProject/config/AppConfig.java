package me.bactoria.boardProject.config;

import me.bactoria.boardProject.accounts.AccountService;
import me.bactoria.boardProject.accounts.dto.SaveRequestAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Autowired
            AccountService accountService;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                SaveRequestAccountDto dto1 = SaveRequestAccountDto.builder()
                        .email("bactoria@gmail.com")
                        .password("pass")
                        .build();
                accountService.saveAccount(dto1);

                SaveRequestAccountDto dto2 = SaveRequestAccountDto.builder()
                        .email("test@gmail.com")
                        .password("pass")
                        .build();
                accountService.saveAccount(dto2);
            }
        };
    }
}
