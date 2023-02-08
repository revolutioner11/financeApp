package com.volleyball.financeApp.account;

import com.volleyball.financeApp.volleyballTeam.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Player, UUID> {

    @Query("SELECT s FROM Player s WHERE s.teamNumber = ?1")
    Optional<Player> findPlayerByNumber(int teamNumber);

    @Query("SELECT s FROM Player s WHERE s.playerID = ?1")
    Optional<Player> findPlayerByID(UUID playerID);
}
