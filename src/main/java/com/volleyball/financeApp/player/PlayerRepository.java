package com.volleyball.financeApp.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT s FROM Player s WHERE s.teamNumber = ?1")
    Optional<Player> findPlayerByNumber(int teamNumber);
}
