package com.charliekriska.exoplanetdata.dao;

import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ExoPlanetDbImplTest {

    private MockWebServer mockServer;

    @Autowired
    private ExoPlanetDao exoPlanetDao;

    @BeforeAll
    void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.start();
    }
    @AfterAll
    void tearDown() throws IOException {
        mockServer.shutdown();
    }
    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s", mockServer.getPort());
    }

}
