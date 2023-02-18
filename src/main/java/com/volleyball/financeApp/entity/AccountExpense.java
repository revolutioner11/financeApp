package com.volleyball.financeApp.entity;

import javax.persistence.*;

// @ not entity but what?
@Entity
//@Table
public class AccountExpense {
    @EmbeddedId
    private CompositeKey compositeKey;
    private float amount;
    @ManyToOne
    private BankAccount bankAccount;
    @ManyToOne
    private Expense expense;

    public AccountExpense() {}
    AccountExpense(float amount, BankAccount bankAccount, Expense expense) {
        this.amount = amount;
        this.bankAccount = bankAccount;
        this.expense = expense;
        this.compositeKey = new CompositeKey(bankAccount.getBankAccountID(), expense.getExpenseNumber());
    }
}
