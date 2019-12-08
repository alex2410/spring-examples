package ru.trushkin.spring.bank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Bank {
    @Id
    private long id;

    @Column(scale = 2)
    private BigDecimal amount;

    public void credit(BigDecimal value) {
        amount = amount.subtract(value);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
