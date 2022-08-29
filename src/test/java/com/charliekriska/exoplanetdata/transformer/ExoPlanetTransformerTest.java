package com.charliekriska.exoplanetdata.transformer;

import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import com.charliekriska.exoplanetdata.utility.SampleData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExoPlanetTransformerTest {

    private final double PARSEC_MULTIPLIER = 3.26156;

    @Test
    public void testPlanetDtoToPlanet() {
        PlanetDto planetDto = SampleData.getPlanetDto();
        Planet planet = ExoPlanetTransformer.planetDtoToPlanet(planetDto);
        assertEquals(planetDto.getPl_name(), planet.getName());
        assertEquals(planetDto.getDisc_year(), planet.getDiscoveryYear());
    }

    @Test
    public void testStarDtoToStar() {
        StarDto starDto = SampleData.getStarDto();
        Star star = ExoPlanetTransformer.starDtoToStar(starDto);
        assertEquals(starDto.getHostname(), star.getName());
        assertEquals(starDto.getSt_age(), star.getAge());
    }

    @Test
    public void testStarSystemDtoToStarSystem() {
        StarSystemDto starSystemDto = SampleData.getStarSystemDto();
        StarSystem starSystem = ExoPlanetTransformer.starSystemDtoToStarSystem(starSystemDto);
        assertEquals(starSystemDto.getHostname(), starSystem.getHost().getName());
        assertEquals(starSystemDto.getRa(), starSystem.getRightAscension());
        assertEquals(starSystemDto.getPl_name(), starSystem.getPlanets().get(0).getName());
        assertEquals(starSystemDto.getSy_dist()*PARSEC_MULTIPLIER, starSystem.getDistance());
    }

}
