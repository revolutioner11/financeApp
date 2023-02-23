package com.volleyball.financeApp.entity;

import com.volleyball.financeApp.team.Team;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class TeamBank {
    @Id
    private final UUID teamBankID;

    @OneToOne
    private Team team;
    private UUID adminID;
    private float overallToCollect;
    private float collected;
    private float overallToPay;
    private float paid;
    private float moneyAvailable;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<Installment> installments;
    @OneToMany
    private List<Installment> installmentRequests;

    public TeamBank() {
        expenses = new LinkedList<Expense>();
        installments = new LinkedList<Installment>();
        installmentRequests = new LinkedList<Installment>();
        teamBankID = UUID.randomUUID();
    }
    public TeamBank(@NotNull Team team) {
        teamBankID = team.getTeamId();
        expenses = new LinkedList<Expense>();
        installments = new LinkedList<Installment>();
        installmentRequests = new LinkedList<Installment>();
        this.team = team;
    }
    public float getOverallToCollect() {
        return overallToCollect;
    }
    public float getCollected() {
        return collected;
    }
    public float getLeftToCollect() {
        return overallToCollect - collected;
    }
    public float getOverallToPay() {
        return overallToPay;
    }
    public float getPaid() {
        return paid;
    }
    public float getLeftToPay() {
        return overallToPay - paid;
    }
    public float getMoneyAvailable() {
        return moneyAvailable;
    }
    boolean addExpense(Expense newExpense) {
        expenses.add(newExpense);
        return true;
    }
    boolean requestInstallment(@NotNull Installment newInstallment) {
        if (newInstallment.getBankAccount().isIdEqual(adminID)) {
            addInstallment(newInstallment);
        }
        else {
            installmentRequests.add(newInstallment);
        }
        return true;
    }
    private void addInstallment(Installment newInstallment) {
        installments.add(newInstallment);
        newInstallment.getBankAccount().addInstallment(newInstallment);
        collected += newInstallment.getAmount();
        moneyAvailable += newInstallment.getAmount();
    }
    private void setAdminID(UUID adminID) {
        this.adminID = adminID;
    }
}
