package com.volleyball.financeApp.controller;

import com.volleyball.financeApp.entity.Team;
import com.volleyball.financeApp.service.TeamBankService;
import com.volleyball.financeApp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
