package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.config.Config;
import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import com.charliekriska.exoplanetdata.utility.SampleData;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExoPlanetDbImplTest {

    private MockWebServer mockServer;
    private ExoPlanetDao exoPlanetDao;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockServer = new MockWebServer();
        Config config = new Config();
        config.setBaseUrl(mockServer.url("/").url().toString());
        config.setFormat("json");
        exoPlanetDao = new ExoPlanetDaoImpl(WebClient.builder(), config);
    }

    @Test
    public void testGetAllPlanetData() throws Exception {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(SampleData.getSamplePlanetDtoList())));

        List<PlanetDto> planetDtos = exoPlanetDao.getAllPlanetData();
        assertEquals(planetDtos.get(0).getPl_name(), "Planet 1");
        assertEquals(planetDtos.get(1).getPl_name(), "Planet 2");
    }

    @Test
    public void testGetAllStarData() throws Exception {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(SampleData.getSampleStarDtoList())));

        List<StarDto> starDtos = exoPlanetDao.getAllStarData();
        assertEquals(starDtos.get(0).getHostname(), "hostname 1");
        assertEquals(starDtos.get(1).getHostname(), "hostname 2");
    }

    @Test
    public void testGetAllStarSystemData() throws Exception {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(SampleData.getSampleStarSystemDtoList())));

        List<StarSystemDto> starSystemDtos = exoPlanetDao.getAllStarSystemData();
        assertEquals(starSystemDtos.get(0).getHostname(), "hostname 1");
        assertEquals(starSystemDtos.get(0).getRa(), 1.2);
        assertEquals(starSystemDtos.get(1).getHostname(), "hostname 2");
        assertEquals(starSystemDtos.get(1).getRa(), 2.7);

    }

}
