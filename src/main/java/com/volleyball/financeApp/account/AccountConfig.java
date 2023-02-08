package com.volleyball.financeApp.account;

import com.volleyball.financeApp.volleyballTeam.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            Player james = new Player("James", 10);
            Player alex = new Player("Alex", 20);
            repository.saveAll(List.of(james, alex));
        };
    }

}
