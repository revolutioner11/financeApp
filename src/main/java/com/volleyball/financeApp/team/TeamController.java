package com.volleyball.financeApp.team;

import com.volleyball.financeApp.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    ///         GET        ///
    @GetMapping(path = "{teamId}")
    public List<Player> getAllPlayers(@PathVariable("teamId") UUID teamId) {
        return teamService.getAllPlayers(teamId);
    }

    ///         /GET        ///
    ///         POST        ///
    @PostMapping(path = "{teamId}")
    public void addNewPlayer(@PathVariable("teamId") UUID teamId, @RequestBody Player player) {
        teamService.addNewPlayer(teamId, player);
    }

    @PostMapping
    public void registerNewTeam(@RequestBody Team team) {
        teamService.addNewTeam(team);
    }

    ///         /POST        ///
    ///         DELETE        ///
    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") UUID teamId) {
        teamService.deleteTeam(teamId);
    }

    @DeleteMapping(path = "{teamId}")
    public void deletePlayer(@PathVariable("teamId") UUID teamId, UUID playerId) {
        teamService.deletePlayer(teamId, playerId);
    }

    ///         /DELETE        ///
    ///         PUT        ///
    @PutMapping(path = "{teamId}")
    public void updatePlayer(
            @PathVariable("teamId") UUID teamId,
            @RequestParam(required = false) String teamName,
            @RequestParam(required = false) LocalDate dateCreated) {
        teamService.updateTeam(teamId, teamName, dateCreated);
    }
    ///         /PUT        ///
}
