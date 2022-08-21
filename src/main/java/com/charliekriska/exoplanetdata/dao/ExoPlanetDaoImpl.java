package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.config.Config;
import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Repository
public class ExoPlanetDaoImpl implements ExoPlanetDao {

    private final WebClient client;
    private final Config config;


    public ExoPlanetDaoImpl(WebClient.Builder webClientBuilder, Config config) {
        this.client = webClientBuilder.baseUrl(config.getBaseUrl()).build();
        this.config = config;
    }

    @Override
    public List<PlanetDto> getAllPlanetData() {
        return getData(config.getPlanetDataQuery()).bodyToMono(new ParameterizedTypeReference<List<PlanetDto>>() {}).block();
    }

    @Override
    public List<StarDto> getAllStarData() {
        return getData(config.getStarDataQuery()).bodyToMono(new ParameterizedTypeReference<List<StarDto>>() {}).block();
    }

    @Override
    public List<StarSystemDto> getAllStarSystemData() {
        return getData(config.getSystemDataQuery()).bodyToMono(new ParameterizedTypeReference<List<StarSystemDto>>() {}).block();
    }

    public WebClient.ResponseSpec getData(String query) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", query)
                        .queryParam("format",config.getFormat())
                        .build())
                .retrieve();
    }


}
