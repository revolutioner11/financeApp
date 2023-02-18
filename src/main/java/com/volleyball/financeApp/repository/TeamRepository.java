package com.volleyball.financeApp.repository;

import com.volleyball.financeApp.entity.Player;
import com.volleyball.financeApp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {

//    @Query("SELECT s FROM Player s WHERE s.teamNumber = ?1")
//    Optional<Player> findTeamByNumber(int teamNumber);

    @Query("SELECT s FROM Team s WHERE s.teamId = ?1")
    Optional<Team> findTeamById(UUID teamId);
}
