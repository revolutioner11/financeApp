package com.volleyball.financeApp.configuration;

import com.volleyball.financeApp.entity.Player;
import com.volleyball.financeApp.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            //Player james = new Player("James", 10);
            //Player alex = new Player("Alex", 20);
            //repository.saveAll(List.of(james, alex));
        };
    }

}
