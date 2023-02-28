package com.volleyball.financeApp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/team/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService accountService) {
        this.playerService = accountService;
    }

    ///         GET         ///
    @GetMapping(path = "{playerId}")
    public Player getPlayerById(@PathVariable("playerId") UUID playerId) {
        return playerService.getPlayerById(playerId);
    }
    ///         /GET        ///
    ///         POST        ///
    @PostMapping
    public void addNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
    }
    ///         /POST       ///
    ///        DELETE       ///
    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") UUID playerId) {
        playerService.deletePlayer(playerId);
    }
    ///       /DELETE       ///
    ///         PUT         ///
    @PutMapping(path = "{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") UUID playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int teamNumber) {
        playerService.updatePlayer(playerId, name, teamNumber);
    }
    ///        /PUT         ///
}
