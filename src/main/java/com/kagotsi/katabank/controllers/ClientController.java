package com.kagotsi.katabank.controllers;


import com.kagotsi.katabank.exception.KataBankException;
import com.kagotsi.katabank.models.Account;
import com.kagotsi.katabank.models.Client;
import com.kagotsi.katabank.models.payloads.AccountRequest;
import com.kagotsi.katabank.models.payloads.ApiResponse;
import com.kagotsi.katabank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * Title: ClientController class
 * Description: ClientController
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("")
    public ResponseEntity save(@RequestParam("name") String name){
        final  Client  client =  clientService.save(new Client(name));
        return ResponseEntity.ok(new ApiResponse(client, true));
    }
}
