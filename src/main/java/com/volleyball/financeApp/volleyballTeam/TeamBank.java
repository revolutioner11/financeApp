package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
class TeamBank {
    @Id
    private UUID bankID;

    private float overallToCollect;
    private float collected;
    private float leftToCollect;

    private float overallToPay;
    private float paid;
    private float leftToPay;

    private float moneyAvailable;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<Installment> installments;

    public TeamBank() {
        expenses = new LinkedList<Expense>();
        installments = new LinkedList<Installment>();
        bankID = UUID.randomUUID();
    }

    TeamBank(UUID teamID) {
        bankID = teamID;
        expenses = new LinkedList<Expense>();
        installments = new LinkedList<Installment>();
    }
}
