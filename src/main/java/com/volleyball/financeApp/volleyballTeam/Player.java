package com.volleyball.financeApp.volleyballTeam;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volleyball.financeApp.volleyballTeam.BankAccount;
import com.volleyball.financeApp.volleyballTeam.VolleyballTeam;

import javax.persistence.*;
import java.time.Period;
import java.util.UUID;

@Entity
@Table
public class Player {
    @Id
    private UUID playerID;
    @ManyToOne
    private VolleyballTeam volleyballTeam;
    private int teamNumber = 0;
    private String name = "Other";
    @OneToOne
    BankAccount bankAccount;

//    @Transient
//    double leftToPay = 0;

    public Player() {
        name = "Other";
        teamNumber = 0;
    }
    public Player(String name, int number) {
        playerID = UUID.randomUUID();
        this.name = name;
        this.teamNumber = number;
        bankAccount = new BankAccount(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getName() {
        return name;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    @Override
    public String toString() {
        return name + ", " + teamNumber;
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public VolleyballTeam getVolleyballTeam() {
        return volleyballTeam;
    }
}