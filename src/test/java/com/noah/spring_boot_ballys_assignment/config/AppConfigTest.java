package com.noah.spring_boot_ballys_assignment.config;// Import necessary packages
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private SecurityFilterChain securityFilterChain;

    @Autowired
    private CorsConfigurationSource corsConfigurationSource;

    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;

    @MockBean
    private HttpServletRequest request;

    @Test
    void contextLoads() {
        // Test if the beans are loaded correctly
        assertNotNull(securityFilterChain, "SecurityFilterChain bean should be loaded");
        assertNotNull(corsConfigurationSource, "CorsConfigurationSource bean should be loaded");
    }

    @Test
    void testCorsConfiguration() {
        // Test the CORS configuration
        CorsConfiguration corsConfig = corsConfigurationSource.getCorsConfiguration(request);
        assertNotNull(corsConfig, "CorsConfiguration should not be null");
        assertEquals(1, corsConfig.getAllowedOrigins().size());
        assertEquals(Collections.singletonList(allowedOrigins), corsConfig.getAllowedOrigins(), "Allowed origins should match configuration");
        assertEquals(Collections.singletonList("GET"), corsConfig.getAllowedMethods(), "Allowed methods should match");
        assertEquals(Collections.singletonList("*"), corsConfig.getAllowedHeaders(), "Allowed headers should match");
        assertEquals(true, corsConfig.getAllowCredentials(), "Allow credentials should be true");

    }
}
