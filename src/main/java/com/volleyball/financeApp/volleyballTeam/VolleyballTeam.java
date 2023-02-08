package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table
public class VolleyballTeam {
    @Id
    private UUID volleyballTeamID;
    private String teamName;
    private LocalDate dateCreated;
    @OneToMany
    private List<Player> playerList;
    @OneToOne
    private TeamBank teamBank;



    VolleyballTeam() {
        volleyballTeamID = UUID.randomUUID();
        teamName = "Team has no name yet!";
        dateCreated = LocalDate.now();
        playerList = new ArrayList<Player>();
        teamBank = new TeamBank(this);
    }

    VolleyballTeam(String teamName, LocalDate dateCreated) {
        volleyballTeamID = UUID.randomUUID();
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

    UUID getVolleyballTeamID() {
        return volleyballTeamID;
    }
}
