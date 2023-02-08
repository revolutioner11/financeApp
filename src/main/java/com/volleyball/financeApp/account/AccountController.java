package com.volleyball.financeApp.account;

import com.volleyball.financeApp.volleyballTeam.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/player/bank_account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return accountService.getPlayers();
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player) {
        accountService.addNewPlayer(player);
    }

    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") UUID playerId) {
        accountService.deletePlayer(playerId);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") UUID playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int teamNumber) {
        accountService.updatePlayer(playerId, name, teamNumber);
    }
}
