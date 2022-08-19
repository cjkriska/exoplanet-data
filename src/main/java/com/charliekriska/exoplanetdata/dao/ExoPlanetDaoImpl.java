package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Repository
public class ExoPlanetDaoImpl implements ExoPlanetDao {

    private final String URL = "https://exoplanetarchive.ipac.caltech.edu/TAP/sync";
    private final String FORMAT = "json";
    private final String PLANET_DATA_QUERY = "select+pl_name,hostname,pl_letter,discoverymethod,disc_year,pl_orbper,pl_orbsmax,pl_rade,pl_bmasse,pl_dens,pl_orbeccen,pl_eqt+from+pscomppars+order+by+sy_dist";
    private final String STAR_DATA_QUERY = "select+hostname,st_spectype,st_teff,st_rad,st_mass,st_met,st_metratio,st_lum,st_age,st_dens,st_rotp,st_radv,sy_dist+from+pscomppars+order+by+sy_dist";
    private final String STAR_SYSTEM_DATA_QUERY = "select+pl_name,hostname,pl_letter,discoverymethod,disc_year,pl_orbper,pl_orbsmax,pl_rade,pl_bmasse,pl_dens,pl_orbeccen,pl_eqt,st_spectype,st_teff,st_rad,st_mass,st_met,st_metratio,st_lum,st_age,st_dens,st_rotp,st_radv,sy_dist,ra,dec,glat,glon,elat,elon,sy_snum,sy_pnum,sy_mnum+from+pscomppars+order+by+sy_dist";

    private final WebClient client;

    public ExoPlanetDaoImpl(WebClient.Builder webClientBuilder) {
        this.client = webClientBuilder.baseUrl(URL).build();
    }

    @Override
    public List<PlanetDto> getAllPlanetData() {
        return getData(PLANET_DATA_QUERY).bodyToMono(new ParameterizedTypeReference<List<PlanetDto>>() {}).block();
    }

    @Override
    public List<StarDto> getAllStarData() {
        return getData(STAR_DATA_QUERY).bodyToMono(new ParameterizedTypeReference<List<StarDto>>() {}).block();
    }

    @Override
    public List<StarSystemDto> getAllStarSystemData() {
        return getData(STAR_SYSTEM_DATA_QUERY).bodyToMono(new ParameterizedTypeReference<List<StarSystemDto>>() {}).block();
    }

    public WebClient.ResponseSpec getData(String query) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", query)
                        .queryParam("format",FORMAT)
                        .build())
                .retrieve();
    }


}
