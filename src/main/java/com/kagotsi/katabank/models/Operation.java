package com.kagotsi.katabank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TYPE")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Withdrawal.class, name = "Withdrawal"),
        @JsonSubTypes.Type(value = Operation.class, name = "Operation") }
)
public abstract class  Operation extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long operationNumber;

    @Column(name = "amount")
    protected Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_code")
    @JsonIgnore
    protected Account account;

    @Column(name = "nature")
    protected String nature;

    public Operation() {
    }

    public Operation(Double amount, Account account) {
        this.amount = amount;
        this.account = account;
    }

    public Long getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(Long operationNumber) {
        this.operationNumber = operationNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
