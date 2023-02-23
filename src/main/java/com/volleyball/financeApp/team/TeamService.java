package com.volleyball.financeApp.team;

import com.volleyball.financeApp.player.Player;
import com.volleyball.financeApp.player.PlayerService;
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
    private final PlayerService playerService;

    @Autowired
    public TeamService(TeamRepository teamRepository, PlayerService playerService) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
    }

    ///         GET        ///
    public List<Player> getAllPlayers(UUID teamId) {
        Team team = teamRepository.findTeamById(teamId).orElseThrow(
                () -> new IllegalStateException("Team with id: " + teamId + " does not exist!"));
        return team.getAllPlayers();
    }

    //    public List<Team> getTeams() {
    //        return teamRepository.findAll();
    //    }

    ///         /GET        ///
    ///         POST        ///
    public void addNewPlayer(UUID teamId, Player player) {
        Team team = teamRepository.findTeamById(teamId).orElseThrow(
                () -> new IllegalStateException("Team with id: " + teamId + " does not exist!"));
        team.addPlayer(player);
        teamRepository.save(team);
    }

    public void addNewTeam(@NotNull Team team) {
        Optional<Team> teamOptional = teamRepository.findTeamById(team.getTeamId());
        if (teamOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        teamRepository.save(team);
    }

    ///         /POST        ///
    ///         DELETE        ///

    public void deleteTeam(UUID teamId) {
        boolean exists =  teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("Team with id: " + teamId + " does not exist!");
        }
        teamRepository.deleteById(teamId);
    }
    public void deletePlayer(UUID teamId, UUID playerId) {
        Team team = teamRepository.findTeamById(teamId).orElseThrow(
                () -> new IllegalStateException("Team with id: " + teamId + " does not exist!"));
        Player player = playerService.getPlayerById(playerId);      /// what if exception?
        team.deletePlayer(player);

        playerService.deletePlayer(playerId);

    }

    ///         /DELETE        ///
    ///          PUT           ///
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


    ///          /PUT         ///


}
