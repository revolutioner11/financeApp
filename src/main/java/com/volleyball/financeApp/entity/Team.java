package com.volleyball.financeApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table
public class Team {
    @Id
    private UUID teamId;
    private String teamName;
  //  @Temporal(TemporalType.DATE)
    private LocalDate dateCreated;
    @OneToMany
    private List<Player> playerList;
    @OneToOne
    private TeamBank teamBank;

    Team() {
        teamId = UUID.randomUUID();
        teamName = "Team has no name yet!";
        dateCreated = LocalDate.now();
        playerList = new ArrayList<Player>();
        teamBank = new TeamBank(this);
    }

    Team(String teamName, LocalDate dateCreated) {
        teamId = UUID.randomUUID();
        this.teamName = teamName;
        this.dateCreated = dateCreated;
        playerList = new ArrayList<Player>();
    }

    boolean addPlayer(Player newPlayer) {
        if (playerList.contains(newPlayer)) {
            return false;
        }
        else {
            playerList.add(newPlayer);
            return true;
        }
    }
    public TeamBank getTeamBank() {
        return teamBank;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
