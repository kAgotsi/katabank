package com.kagotsi.katabank.controllers;

import com.kagotsi.katabank.exception.KataBankException;
import com.kagotsi.katabank.models.Account;
import com.kagotsi.katabank.models.Client;
import com.kagotsi.katabank.models.payloads.AccountRequest;
import com.kagotsi.katabank.models.payloads.ApiResponse;
import com.kagotsi.katabank.services.AccountService;
import com.kagotsi.katabank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * Title: AccountController class
 * Description: AccountController
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @PostMapping("")
    public ResponseEntity save(@RequestBody AccountRequest accountRequest){
        final Client client = clientService.findById(accountRequest.getClientId()).orElseThrow(()->
                new KataBankException("Unable to find  client number:  [" +accountRequest.getClientId() + "]"));
        final Account account = new Account(accountRequest.getAccountNumber(), 0.0,client);
        final  Account newAccount =  accountService.save(account);
        return ResponseEntity.ok(new ApiResponse(newAccount, true));
    }
}
