package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.config.Config;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.reactive.function.client.WebClient;


public class ExoPlanetDbImplTest {

    private MockWebServer mockServer;
    private ExoPlanetDao exoPlanetDao;

    @BeforeEach
    void initialize() {
        mockServer = new MockWebServer();
        Config config = new Config();
        config.setBaseUrl(mockServer.url("/").url().toString());
        exoPlanetDao = new ExoPlanetDaoImpl(WebClient.builder(), config);
    }

}
