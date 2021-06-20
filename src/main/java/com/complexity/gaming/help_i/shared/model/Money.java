package com.complexity.gaming.help_i.shared.model;

import javax.persistence.Embeddable;

@Embeddable
public class Money {

    private String currency;
    private Double amount;

    public Money(String currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money() {
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    private Money setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    private Money setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
