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

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(UUID playerId){
        return playerRepository.findPlayerById(playerId).orElseThrow(
                () -> new IllegalStateException("Player with id: " + playerId + " does not exist!"));
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerById(player.getPlayerID());
        if (playerOptional.isPresent()) {
            throw new IllegalStateException("number taken");
            ///
            ///
            ///         MORE LOGIC !
            ///
            ///
        }
        playerRepository.save(player);
    }

    public void deletePlayer(UUID playerId) {
        boolean exists =  playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("Player with id: " + playerId + " does not exist!");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(UUID playerId, String name, int teamNumber) {
        Player player = playerRepository.findPlayerById(playerId).orElseThrow(
                () -> new IllegalStateException("Player with id: " + playerId + " does not exist!"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }

        if (player.getTeamNumber() != teamNumber) {
            Optional<Player> playerOptional = playerRepository.findPlayerByNumber(teamNumber);
            if (playerOptional.isPresent()) {
                throw new IllegalStateException("number taken");
            }
            player.setTeamNumber(teamNumber);
        }
    }
}
