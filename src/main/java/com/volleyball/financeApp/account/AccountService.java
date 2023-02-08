package com.volleyball.financeApp.account;

import com.volleyball.financeApp.volleyballTeam.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Player> getPlayers() {
        return accountRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = accountRepository.findPlayerByNumber(player.getTeamNumber());
        if (playerOptional.isPresent()) {
            throw new IllegalStateException("number taken");
        }
        accountRepository.save(player);
    }

    public void deletePlayer(UUID playerId) {
        boolean exists =  accountRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("Player with id: " + playerId + " does not exist!");
        }
        accountRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(UUID playerId, String name, int teamNumber) {
        Player player = accountRepository.findPlayerByID(playerId).orElseThrow(
                () -> new IllegalStateException("Player with id: " + playerId + " does not exist!"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }

        if (player.getTeamNumber() != teamNumber) {
            Optional<Player> playerOptional = accountRepository.findPlayerByNumber(teamNumber);
            if (playerOptional.isPresent()) {
                throw new IllegalStateException("number taken");
            }
            player.setTeamNumber(teamNumber);
        }
    }
}
