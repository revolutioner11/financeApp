package com.volleyball.financeApp.controller;

import com.volleyball.financeApp.service.TeamBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/team/bank")
public class TeamBankController {
    private final TeamBankService teamBankService;

    @Autowired
    public TeamBankController(TeamBankService teamBankService) {
        this.teamBankService = teamBankService;
    }

    @GetMapping
    public

}
