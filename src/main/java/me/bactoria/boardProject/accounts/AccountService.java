package me.bactoria.boardProject.accounts;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.accounts.dto.SaveRequestAccountDto;
import me.bactoria.boardProject.accounts.dto.UpdateRequestAccountDto;
import me.bactoria.boardProject.errors.exceptions.AccountAlreadyExistException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account saveAccount(SaveRequestAccountDto dto) {

        accountRepository.findByEmail(dto.getEmail())
                .ifPresent(account -> {
                    throw new AccountAlreadyExistException(account.getEmail());
                });

        Account account = Account.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phone(dto.getPhone())
                .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                .build();

        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account currentUser, UpdateRequestAccountDto dto) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(id.toString()));

        validateAuthorization(currentUser, account);

        account.setPassword(dto.getPassword());
        account.setName(dto.getName());
        account.setPhone(dto.getPhone());

        return accountRepository.save(account);
    }

    private void validateAuthorization(Account currentUser, Account account) {
        if (!isEqualUser(currentUser, account)) {
            throw new UserDeniedAuthorizationException(currentUser.getId().toString());
        }
    }

    private boolean isEqualUser(Account currentUser, Account account) {
        return currentUser.getId() == account.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new AccountAdapter(account);
    }

}
