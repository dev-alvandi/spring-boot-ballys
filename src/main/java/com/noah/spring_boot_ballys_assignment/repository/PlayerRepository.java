package com.noah.spring_boot_ballys_assignment.repository;

import com.noah.spring_boot_ballys_assignment.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // There is no need to add any extra method here. /Noah

    List<Player> findAllByOrderByBirthDateDesc();
}
