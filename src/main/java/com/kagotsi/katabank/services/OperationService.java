package com.kagotsi.katabank.services;

import com.kagotsi.katabank.exception.KataBankException;
import com.kagotsi.katabank.models.Account;
import com.kagotsi.katabank.models.Deposit;
import com.kagotsi.katabank.models.Operation;
import com.kagotsi.katabank.models.Withdrawal;
import com.kagotsi.katabank.repositories.AccountRepository;
import com.kagotsi.katabank.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository  operationRepository;
    @Autowired
    private AccountRepository accountRepository;

    public  Double deposit(Account account, double amount){
        Deposit deposit = new Deposit(amount,account);
        final Instant  today = new Date().toInstant();
        deposit.setCreatedAt(today);
        deposit.setUpdatedAt(today);
        deposit.setNature("deposit");
        operationRepository.save(deposit);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return account.getBalance();
    }

    public  Double withdrawal(Account account, double amount){
        Withdrawal withdrawal = new Withdrawal(amount,account);
        final Instant  today = new Date().toInstant();
        withdrawal.setCreatedAt(today);
        withdrawal.setUpdatedAt(today);
        withdrawal.setNature("withdrawal");
        operationRepository.save(withdrawal);
        if(account.getBalance() < amount)
            throw new   KataBankException("Insufficient balance ");
        else
            account.setBalance(account.getBalance()-amount);
            accountRepository.save(account);
            return account.getBalance();
    }

    public List<Operation> operations(Long accountNumber){
        return operationRepository.operations(accountNumber);
    }
}
