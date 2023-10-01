package com.example.library_application.controller;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.agreement.CreateAgreementRequest;
import com.example.library_application.dto.agreement.UpdateAgreementRequest;
import com.example.library_application.entity.enums.AgreementStatus;
import com.example.library_application.service.implementation.AgreementServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("library/agreement")
public class AgreementController {
    private final AgreementServiceImp agreementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementResponse create(@RequestBody @Valid CreateAgreementRequest request) {
        return agreementService.createAgreement(request);
    }

    @GetMapping("all_agreements")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AgreementResponse> gelAllAgreements() {
        return agreementService.gelAllAgreements();
    }

    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.FOUND)
    public AgreementResponse findByAgreementNumber(@PathVariable("number") String number) {
        return agreementService.findByAgreementNumber(number);
    }

    @DeleteMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAgreement(@PathVariable("number") String number) {
        agreementService.deleteAgreement(number);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementResponse updateAgreement(@RequestBody @Valid UpdateAgreementRequest request) {
        return agreementService.updateAgreement(request);
    }

    @GetMapping("/{status}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AgreementResponse> getAllAgreementsByStatus(@PathVariable("status") AgreementStatus status) {
        return agreementService.getAllAgreementsByStatus(status);
    }
}
