package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class CompositeKey implements Serializable {

    @Column(name = "BankAccountId", nullable = false)
    private UUID bankAccountId;

    @Column(name = "ExpenseNumber", nullable = false)
    private long expenseNumber;

    CompositeKey() {}
    CompositeKey(UUID bankAccountId, long expenseNumber) {
        this.bankAccountId = bankAccountId;
        this.expenseNumber = expenseNumber;
    }
}
