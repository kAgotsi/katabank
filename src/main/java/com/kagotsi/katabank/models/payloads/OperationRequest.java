package com.kagotsi.katabank.models.payloads;

public class OperationRequest {
    private Long accountNumber;
    private Double amount;

    public OperationRequest(Long accountNumber, Double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
