package com.kagotsi.katabank.services;

import com.kagotsi.katabank.models.Account;
import com.kagotsi.katabank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> findOne(Long accountNumber){
        return accountRepository.findById(accountNumber);
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }
}
