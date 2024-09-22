package com.noah.spring_boot_ballys_assignment.service;

import com.noah.spring_boot_ballys_assignment.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayersSortedByBirthDate();
}
