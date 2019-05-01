package me.bactoria.boardProject.accounts;

import lombok.RequiredArgsConstructor;
import me.bactoria.boardProject.accounts.dto.SaveRequestAccountDto;
import me.bactoria.boardProject.accounts.dto.UpdateRequestAccountDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity saveAccount(@RequestBody SaveRequestAccountDto dto) {
        Account savedAccount = accountService.saveAccount(dto);
        URI createdUri = linkTo(AccountController.class).slash(savedAccount.getId()).toUri();
        return ResponseEntity.created(createdUri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable Long id,
                                        @RequestBody UpdateRequestAccountDto dto,
                                        @AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account") Account currentUser) {
        Account updatedAccount = accountService.updateAccount(id, currentUser, dto);
        return ResponseEntity.ok(updatedAccount);
    }
}
