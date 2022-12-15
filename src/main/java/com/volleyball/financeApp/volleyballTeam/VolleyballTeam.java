package com.volleyball.financeApp.volleyballTeam;

import com.volleyball.financeApp.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table
public class VolleyballTeam {
    @Id
    private UUID teamID;
    private String teamName;
    private LocalDate dateCreated;
    @OneToMany
    private List<Player> playerList;
    @OneToOne
    private TeamBank teamBank;

    VolleyballTeam() {
        teamID = UUID.randomUUID();
        teamName = "Team has no name yet!";
        dateCreated = LocalDate.now();
        playerList = new ArrayList<Player>();
        teamBank = new TeamBank(teamID);
    }

    VolleyballTeam(String teamName, LocalDate dateCreated) {
        teamID = UUID.randomUUID();
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
}
