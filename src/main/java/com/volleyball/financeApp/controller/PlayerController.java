package com.volleyball.financeApp.controller;

import com.volleyball.financeApp.service.PlayerService;
import com.volleyball.financeApp.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/team/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService accountService) {
        this.playerService = accountService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") UUID playerId) {
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") UUID playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int teamNumber) {
        playerService.updatePlayer(playerId, name, teamNumber);
    }
}
