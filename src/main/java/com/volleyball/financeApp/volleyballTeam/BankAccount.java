package com.volleyball.financeApp.volleyballTeam;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class BankAccount {
    @Id
    private UUID bankAccountID;

    private float paid;
    private float overallToPay;
    private float leftToPay;

    @OneToMany
    private List<AccountExpense> accountExpenses;
    @OneToMany
    private List<Installment> installments;

    public BankAccount() {
        this.bankAccountID = UUID.randomUUID();
        accountExpenses = new LinkedList<AccountExpense>();
        installments = new LinkedList<Installment>();
    }

    public BankAccount(UUID playerID) {
        this.bankAccountID = playerID;
        accountExpenses = new LinkedList<AccountExpense>();
        installments = new LinkedList<Installment>();
    }
}
