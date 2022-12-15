package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// @ not entity but what?
@Table
public class AccountExpense {
    private float amount;
    @ManyToOne
    private BankAccount bankAccount;
    @ManyToOne
    private Expense expense;

    public AccountExpense() {

    }

    AccountExpense(float amount, BankAccount bankAccount, Expense expense) {
        this.amount = amount;
        this.bankAccount = bankAccount;
        this.expense = expense;
    }

}
