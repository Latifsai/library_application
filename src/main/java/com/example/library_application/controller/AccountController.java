package com.example.library_application.controller;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.account.CreateAccountRequest;
import com.example.library_application.dto.account.UpdateAccountRequest;
import com.example.library_application.service.implementation.AccountServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/account")
public class AccountController {
    private final AccountServiceImp accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody @Valid CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.FOUND)
    public AccountResponse findByAccountNumber(@PathVariable("number") String number) {
        return accountService.findByAccountNumber(number);
    }

    @DeleteMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("number") String number) {
        accountService.deleteAccount(number);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse updateAccount(@RequestBody @Valid UpdateAccountRequest request) {
        return accountService.updateAccount(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountResponse> getAllAccount() {
        return accountService.getAllAccount();
    }
}
