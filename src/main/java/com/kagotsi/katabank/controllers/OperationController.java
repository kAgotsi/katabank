package com.kagotsi.katabank.controllers;


import com.kagotsi.katabank.exception.KataBankException;
import com.kagotsi.katabank.models.Account;
import com.kagotsi.katabank.models.Operation;
import com.kagotsi.katabank.models.payloads.ApiResponse;
import com.kagotsi.katabank.models.payloads.OperationRequest;
import com.kagotsi.katabank.services.AccountService;
import com.kagotsi.katabank.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * Title: OperationController class
 * Description: OperationController
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private AccountService accountService;

    /**
     * Allow user to make deposit of any amount in his account
     *
     * @param operationRequest deposit request
     * @return responseEntity if successful operation with new balance
     */
    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody OperationRequest operationRequest) {
        final Account account = accountService.findOne(operationRequest.getAccountNumber()).orElseThrow(() ->
                new KataBankException("Unable to find the account:  [" + operationRequest + "]"));
        final Double newBalance = operationService.deposit(account, operationRequest.getAmount());
        return ResponseEntity.ok(new ApiResponse("Successful deposit operation , new balance " + newBalance, true));

    }

    /**
     * Allow user to make withdrawal of any amount in his account
     *
     * @param operationRequest withdrawal request
     * @return responseEntity if successful operation with new balance
     */
    @PostMapping("/withdrawal")
    public ResponseEntity withdrawal(@RequestBody OperationRequest operationRequest) {
        final Account account = accountService.findOne(operationRequest.getAccountNumber()).orElseThrow(() ->
                new KataBankException("Unable to find the account:  [" + operationRequest.getAccountNumber() + "]"));
        final Double newBalance = operationService.withdrawal(account, operationRequest.getAmount());
        return ResponseEntity.ok(new ApiResponse("Successful withdrawal operation , new balance " + newBalance, true));
    }

    /**
     * Get all operations in account
     *
     * @param accountNumber account number
     * @return operations
     */
    @GetMapping()
    public ResponseEntity operations(@RequestParam("accountNumber") String accountNumber) {
        final Long accountNumb = Long.parseLong(accountNumber);
        final Account account = accountService.findOne(Long.parseLong(accountNumber)).orElseThrow(() ->
                new KataBankException("Unable to find the account: [" + accountNumber + "]"));
        final List<Operation> operations = operationService.operations(accountNumb);
        return ResponseEntity.ok(new ApiResponse(operations != null ? operations : "No data found", true));
    }
}
