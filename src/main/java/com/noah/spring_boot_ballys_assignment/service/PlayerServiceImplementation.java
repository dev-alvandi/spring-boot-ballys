package com.noah.spring_boot_ballys_assignment.service;

import com.noah.spring_boot_ballys_assignment.model.Player;
import com.noah.spring_boot_ballys_assignment.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImplementation implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getAllPlayersSortedByBirthDate() {
        return playerRepository.findAllByOrderByBirthDateDesc();
    }
}
