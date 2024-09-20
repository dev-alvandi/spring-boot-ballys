package com.noah.spring_boot_ballys_assignment.controller;

import com.noah.spring_boot_ballys_assignment.model.Player;
import com.noah.spring_boot_ballys_assignment.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> allPlayers = playerService.getAllPlayersSortedByBirthDate();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }
}
