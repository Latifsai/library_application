package com.example.library_application.service.util;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.account.CreateAccountRequest;
import com.example.library_application.dto.account.UpdateAccountRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.validation.ValidationMessage;
import com.example.library_application.validation.exeptions.AlreadyExistException;
import com.example.library_application.validation.exeptions.ValidationException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountUtil {
    private final Random random = new SecureRandom();

    public Account createAccount(CreateAccountRequest request, List<Account> list) {
        Account account = new Account();
        account.setUniqueNumber(Generator.getInstance().generateNumber(random.nextInt(6, 21)));

        if (checkUniqueUsername(request.getUsername(), list)){
            account.setUsername(request.getUsername());
        }

        if (checkPassword(request.getPassword())){
            account.setPassword(request.getPassword());
        } else {
            throw new ValidationException(ValidationMessage.NOT_RIGHT_PASSWORD_MESSAGE + request.getPassword());
        }

        account.setEmail(request.getEmail());
        account.setAddress(request.getAddress());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setDocumentType(request.getDocumentType());
        account.setDateOfCreating(Timestamp.valueOf(LocalDateTime.now()));
        account.setDateOfUpdate(Timestamp.valueOf(LocalDateTime.now()));


        return account;
    }

    public AccountResponse convertToResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .uniqueNumber(account.getUniqueNumber())
                .username(account.getUsername())
                .password(account.getPassword())
                .email(account.getEmail())
                .address(account.getAddress())
                .phoneNumber(account.getPhoneNumber())
                .documentType(account.getDocumentType())
                .dateOfCreating(account.getDateOfCreating())
                .dateOfUpdate(account.getDateOfUpdate())
                .build();
    }

    private boolean checkPassword(String password) {
        String passwordValidation = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,20}$";
        Pattern pattern = Pattern.compile(passwordValidation);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    private boolean checkUniqueUsername(String username, List<Account> accounts) {
        Optional<Account> accountFilteredBYUserName = accounts.stream()
                .filter(ac -> ac.getUsername().equals(username))
                .findAny();

        if (accountFilteredBYUserName.isEmpty()) {
            return true;
        }else {
            throw new AlreadyExistException(ValidationMessage.ACCOUNT_ALREADY_EXIST_MESSAGE + username);
        }
    }

    private boolean checkStringCriteria(String criteria){
        return !criteria.trim().isEmpty() && criteria != null;
    }

    public Account updateAccount(UpdateAccountRequest request, Account account, List<Account> list) {
        if (checkStringCriteria(request.getUsername()) && checkUniqueUsername(request.getUsername(), list)) {
            account.setUsername(request.getUsername());
        }
        if (checkPassword(request.getPassword()) && checkStringCriteria(request.getPassword())) {
            account.setUsername(request.getUsername());
        }

        if (checkPassword(request.getEmail())) account.setEmail(request.getEmail());
        if (checkStringCriteria(request.getAddress())) account.setAddress(request.getAddress());
        if (checkStringCriteria(request.getPhoneNumber())) account.setPhoneNumber(request.getPhoneNumber());
        if (request.getDocumentType() != null) account.setDocumentType(request.getDocumentType());
        account.setDateOfUpdate(Timestamp.valueOf(LocalDateTime.now()));
        return account;
    }

}

