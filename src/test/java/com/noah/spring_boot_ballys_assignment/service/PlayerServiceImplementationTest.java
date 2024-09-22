package com.noah.spring_boot_ballys_assignment.service;

import com.noah.spring_boot_ballys_assignment.model.Player;
import com.noah.spring_boot_ballys_assignment.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayerServiceImplementationTest {

    @InjectMocks
    private PlayerServiceImplementation playerService;

    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPlayersSortedByBirthDate() {
        // Arrange
        Player player1 = new Player(1, "John", "Doe", "Skövde", LocalDate.of(1985, 1, 1));
        Player player2 = new Player(2, "Jane", "Smith", "Malmö", LocalDate.of(1985, 5, 15));
        List<Player> players = Arrays.asList(player1, player2);

        // Mock the repository method
        when(playerRepository.findAllByOrderByBirthDateDesc()).thenReturn(players);

        // Act
        List<Player> result = playerService.getAllPlayersSortedByBirthDate();

        // Assert
        assertEquals(players, result);
    }
}
