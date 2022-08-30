package com.charliekriska.exoplanetdata.service;

import com.charliekriska.exoplanetdata.dao.ExoPlanetDao;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import com.charliekriska.exoplanetdata.model.StarSystem;
import com.charliekriska.exoplanetdata.utility.SampleData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExoPlanetServiceImplTest {

    @Mock
    private ExoPlanetDao exoPlanetDao;

    @InjectMocks
    private ExoPlanetServiceImpl exoPlanetService;

    @Test
    public void testGetAllPlanets() {
        when(exoPlanetDao.getAllPlanetData()).thenReturn(SampleData.getSamplePlanetDtoList());
        assertEquals(2, exoPlanetService.getAllPlanets().size());
        assertEquals("Planet 1", exoPlanetService.getAllPlanets().get(0).getName());
        assertEquals("Planet 2", exoPlanetService.getAllPlanets().get(1).getName());
    }

    @Test
    public void testGetAllStars() {
        List<StarDto> sampleList = SampleData.getSampleStarDtoListWithDuplicates();
        when(exoPlanetDao.getAllStarData()).thenReturn(sampleList);
        assertEquals(3, sampleList.size());
        assertEquals(2, exoPlanetService.getAllStars().size());
        assertEquals("hostname 1", exoPlanetService.getAllStars().get(0).getName());
        assertEquals("hostname 2", exoPlanetService.getAllStars().get(1).getName());
    }

    @Test
    public void testGetAllSystems() {
        List<StarSystemDto> sampleList = SampleData.getStarSystemDtoListDuplHostsMultPlanets();
        when(exoPlanetDao.getAllStarSystemData()).thenReturn(sampleList);
        List<StarSystem> starSystems = exoPlanetService.getAllSystems();
        assertEquals(4, sampleList.size());
        assertEquals(2, starSystems.size());
        assertEquals("hostname 1", starSystems.get(0).getHost().getName());
        assertEquals("hostname 2", starSystems.get(1).getHost().getName());
        assertEquals(1.2, starSystems.get(0).getRightAscension());
        assertEquals("Earth", starSystems.get(0).getPlanets().get(0).getName());
        assertEquals("Mars", starSystems.get(0).getPlanets().get(1).getName());
        assertEquals("Jupiter", starSystems.get(0).getPlanets().get(2).getName());
        assertEquals("Kepler-17 b", starSystems.get(1).getPlanets().get(0).getName());
    }

}
