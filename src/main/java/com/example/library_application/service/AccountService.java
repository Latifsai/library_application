package com.example.library_application.service;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.account.CreateAccountRequest;
import com.example.library_application.dto.account.UpdateAccountRequest;

import java.util.List;

public interface AccountService {

    AccountResponse createAccount(CreateAccountRequest request);
    AccountResponse findByAccountNumber(String number);
    void deleteAccount(String number);
    AccountResponse updateAccount(UpdateAccountRequest request);
    List<AccountResponse> getAllAccount();
}
