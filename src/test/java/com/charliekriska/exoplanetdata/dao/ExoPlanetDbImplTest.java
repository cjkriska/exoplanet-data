package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.config.Config;
import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
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
    public void initialize() {
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
                .setBody(mapper.writeValueAsString(getSamplePlanetDtoList())));

        List<PlanetDto> planetDtos = exoPlanetDao.getAllPlanetData();
        assertEquals(planetDtos.get(0).getPl_name(), "Planet 1");
        assertEquals(planetDtos.get(1).getPl_name(), "Planet 2");
    }

    @Test
    public void testGetAllStarData() throws Exception {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(getSampleStarDtoList())));

        List<StarDto> starDtos = exoPlanetDao.getAllStarData();
        assertEquals(starDtos.get(0).getHostname(), "hostname 1");
        assertEquals(starDtos.get(1).getHostname(), "hostname 2");
    }

    @Test
    public void testGetAllStarSystemData() throws Exception {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(getSampleStarSystemDtoList())));

        List<StarSystemDto> starSystemDtos = exoPlanetDao.getAllStarSystemData();
        assertEquals(starSystemDtos.get(0).getHostname(), "hostname 1");
        assertEquals(starSystemDtos.get(0).getSy_dist(), 5.9);
        assertEquals(starSystemDtos.get(1).getHostname(), "hostname 2");
        assertEquals(starSystemDtos.get(1).getSy_dist(), 4.8);

    }

    private List<PlanetDto> getSamplePlanetDtoList() {
        PlanetDto dto1 = PlanetDto.builder()
                .pl_name("Planet 1")
                .hostname("hostname 1")
                .pl_letter("a")
                .discoverymethod("transit")
                .disc_year(2022)
                .pl_orbper(12.34)
                .pl_orbsmax(23.45)
                .pl_rade(34.56)
                .pl_bmasse(45.67)
                .pl_dens(56.78)
                .pl_orbeccen(0.5)
                .pl_eqt(273.4)
                .build();
        PlanetDto dto2 = PlanetDto.builder()
                .pl_name("Planet 2")
                .hostname("hostname 2")
                .pl_letter("b")
                .discoverymethod("transit")
                .disc_year(2021)
                .pl_orbper(12.34)
                .pl_orbsmax(23.45)
                .pl_rade(34.56)
                .pl_bmasse(45.67)
                .pl_dens(56.78)
                .pl_orbeccen(0.5)
                .pl_eqt(273.4)
                .build();
        return List.of(dto1, dto2);
    }

    private List<StarDto> getSampleStarDtoList() {
        StarDto dto1 = StarDto.builder()
                .hostname("hostname 1")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .build();
        StarDto dto2 = StarDto.builder()
                .hostname("hostname 2")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .build();
        return List.of(dto1, dto2);
    }

    private List<StarSystemDto> getSampleStarSystemDtoList() {
        StarSystemDto dto1 = StarSystemDto.builder()
                .hostname("hostname 1")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .sy_dist(5.9)
                .build();
        StarSystemDto dto2 = StarSystemDto.builder()
                .hostname("hostname 2")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .sy_dist(4.8)
                .build();
        return List.of(dto1, dto2);
    }

}
