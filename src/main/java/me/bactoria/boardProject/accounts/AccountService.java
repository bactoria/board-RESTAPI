package me.bactoria.boardProject.accounts;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.accounts.dto.SaveRequestAccountDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account saveAccount(SaveRequestAccountDto dto) {
        Account account = Account.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .build();

        return accountRepository.save(account);
    }
}
