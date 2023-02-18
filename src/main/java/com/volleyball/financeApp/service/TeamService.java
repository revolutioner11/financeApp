package com.volleyball.financeApp.service;

import com.volleyball.financeApp.entity.Player;
import com.volleyball.financeApp.entity.Team;
import com.volleyball.financeApp.repository.TeamRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public void addNewTeam(@NotNull Team team) {
        Optional<Team> teamOptional = teamRepository.findTeamById(team.getTeamId());
        if (teamOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        teamRepository.save(team);
    }

    public void deleteTeam(UUID teamId) {
        boolean exists =  teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("Team with id: " + teamId + " does not exist!");
        }
        teamRepository.deleteById(teamId);
    }

    @Transactional
    public void updateTeam(UUID teamId, String teamName, LocalDate dateCreated) {
        Team team = teamRepository.findTeamById(teamId).orElseThrow(
                () -> new IllegalStateException("Team with id: " + teamId + " does not exist!"));

        if (teamName != null &&
                teamName.length() > 0 &&
                !Objects.equals(team.getTeamName(), teamName)) {
            team.setTeamName(teamName);
        }

        if(!Objects.equals(team.getDateCreated(), dateCreated)) {
            team.setDateCreated(dateCreated);
        }
    }
}
