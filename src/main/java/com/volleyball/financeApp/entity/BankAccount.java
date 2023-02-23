package com.volleyball.financeApp.entity;

import com.volleyball.financeApp.player.Player;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class BankAccount {
    @Id
    private UUID bankAccountID;
    @OneToOne
    private Player player;
    private float paid;
    private float overallToPay;
    @OneToMany
    private List<AccountExpense> accountExpenses;
    @OneToMany
    private List<Installment> installments;

    public BankAccount() {
        this.bankAccountID = UUID.randomUUID();
        accountExpenses = new LinkedList<AccountExpense>();
        installments = new LinkedList<Installment>();
    }
    public BankAccount(Player player) {
        this.player = player;
        this.bankAccountID = player.getPlayerID();
        accountExpenses = new LinkedList<AccountExpense>();
        installments = new LinkedList<Installment>();
    }
    boolean addExpense(AccountExpense newAccountExpense) {
        accountExpenses.add(newAccountExpense);
        return true;
    }
    boolean requestInstallment(Installment newInstallment) {
        getTeamBank().requestInstallment(newInstallment);
        return true;
    }
    void addInstallment(Installment newInstallment) {
        installments.add(newInstallment);
        paid += newInstallment.getAmount();
    }
    TeamBank getTeamBank() {
        return player.getTeam().getTeamBank();
    }
    boolean isIdEqual(UUID id) {
        return this.bankAccountID.equals(id);
    }
    public float getPaid() {
        return paid;
    }
    public float getOverallToPay() {
        return overallToPay;
    }
    public float getleftToPay() {
        return overallToPay - paid;
    }
    UUID getBankAccountID() {
        return bankAccountID;
    }
}
