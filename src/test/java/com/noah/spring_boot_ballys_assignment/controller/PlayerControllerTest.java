package com.noah.spring_boot_ballys_assignment.controller;

import com.noah.spring_boot_ballys_assignment.model.Player;
import com.noah.spring_boot_ballys_assignment.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPlayers() {
        // Arrange
        Player p1 = new Player(1, "Noah", "Alvandi", "Jönköping", LocalDate.of(1999, 10, 7));
        Player p2 = new Player(2, "Jane", "Smith", "Malmö", LocalDate.of(1985, 5, 15));
        List<Player> players = Arrays.asList(p1, p2);

        when(playerService.getAllPlayersSortedByBirthDate()).thenReturn(players);

        // Act
        ResponseEntity<List<Player>> response = playerController.getAllPlayers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(players, response.getBody());
        assertEquals(players.get(1).getFirstName(), "Jane");
        assertEquals(players.get(0).getBirthDate(),
                LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse("1999-10-07")));
    }
}
