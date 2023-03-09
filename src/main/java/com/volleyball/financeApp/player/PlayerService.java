package com.volleyball.financeApp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    ///         GET         ///

    public Player getPlayerById(UUID playerId){
        return playerRepository.findPlayerById(playerId).orElseThrow(
            () -> new IllegalStateException("Player with id: " + playerId + " does not exist!"));
    }

    ///         /GET        ///
    ///         POST        ///

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerByNumber(player.getNumber(), player.getTeam().getTeamId());
        if (playerOptional.isPresent()) {
            throw new IllegalStateException("Player with number " + player.getNumber()
                    + "in team \"" + player.getTeam().getTeamName()+"\" already exists");
        }
        playerRepository.save(player);
    }

    ///         /POST       ///
    ///        DELETE       ///

    public void deletePlayer(UUID playerId) {
        boolean exists =  playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("Player with id: " + playerId + " does not exist!");
        }
        playerRepository.deleteById(playerId);
    }

    ///       /DELETE       ///
    ///         PUT         ///

    @Transactional
    public void updatePlayer(UUID playerId, String name, int teamNumber) {
        Player player = playerRepository.findPlayerById(playerId).orElseThrow(
                () -> new IllegalStateException("Player with id: " + playerId + " does not exist!"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }

        if (player.getNumber() != teamNumber) {
            Optional<Player> playerOptional = playerRepository.findPlayerByNumber(teamNumber, player.getTeam().getTeamId());
            if (playerOptional.isPresent()) {
                throw new IllegalStateException("Number taken!");
            }
            player.setNumber(teamNumber);
        }
    }

    ///        /PUT         ///
}
