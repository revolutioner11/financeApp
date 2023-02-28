package com.volleyball.financeApp.player;

import com.volleyball.financeApp.entity.BankAccount;
import com.volleyball.financeApp.team.Team;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Player {
    @Id
    private UUID playerID;
    @ManyToOne
    private Team team;
    private int number = 0;
    private String name = "Other";
    @OneToOne
    BankAccount bankAccount;

//    @Transient
//    double leftToPay = 0;

    public Player() {
        name = "Other";
        number = 0;
    }
    public Player(String name, int number) {
        playerID = UUID.randomUUID();
        this.name = name;
        this.number = number;
        bankAccount = new BankAccount(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ", " + number;
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public Team getTeam() {
        return team;
    }
}
