package com.volleyball.financeApp.controller;

import com.volleyball.financeApp.entity.Team;
import com.volleyball.financeApp.service.TeamService;
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

    @GetMapping
    public List<Team> getVolleyballTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public void registerNewTeam(@RequestBody Team team) {
        teamService.addNewTeam(team);
    }

    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") UUID teamId) {
        teamService.deleteTeam(teamId);
    }

    @PutMapping(path = "{teamId}")
    public void updatePlayer(
            @PathVariable("teamId") UUID teamId,
            @RequestParam(required = false) String teamName,
            @RequestParam(required = false) LocalDate dateCreated) {
        teamService.updateTeam(teamId, teamName, dateCreated);
    }
}
