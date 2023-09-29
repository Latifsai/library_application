package com.example.library_application.service.implementation;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.account.CreateAccountRequest;
import com.example.library_application.dto.account.UpdateAccountRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.repository.AccountRepository;
import com.example.library_application.service.AccountService;
import com.example.library_application.service.util.AccountUtil;
import com.example.library_application.validation.ValidationMessage;
import com.example.library_application.validation.exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepository repository;
    private final AccountUtil util;

    @Override
    public AccountResponse createAccount(CreateAccountRequest request) {
        List<Account> accounts = repository.findAll();
        Account account = util.createAccount(request, accounts);
        repository.save(account);
        return util.convertToResponse(account);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponse findByAccountNumber(String number) {
        return util.convertToResponse(findByNumber(number));
    }

    @Override
    public void deleteAccount(String number) {
        Account account = findByNumber(number);
        repository.delete(account);
    }

    @Override
    public AccountResponse updateAccount(UpdateAccountRequest request) {
        Account account = findByNumber(request.getNumber());
        Account updatedAccount = util.updateAccount(request, account, repository.findAll());
        repository.save(updatedAccount);
        return util.convertToResponse(updatedAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponse> getAllAccount() {
        return repository.findAll().stream()
                .map(util::convertToResponse)
                .toList();
    }

    public Account findByNumber(String number) {
        return repository.findByUniqueNumber(number)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_ACCOUNT_MESSAGE + number));
    }

}

