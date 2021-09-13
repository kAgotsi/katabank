package com.kagotsi.katabank.models.payloads;

public class AccountRequest {
    private Long accountNumber;
    private Long clientId;

    public AccountRequest() {
    }

    public AccountRequest(Long accountNumber, Long clientId) {
        this.accountNumber = accountNumber;
        this.clientId = clientId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
