package com.charliekriska.exoplanetdata.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "webclient")
public class Config {

    private String baseUrl;
    private String format;
    private String planetDataQuery;
    private String starDataQuery;
    private String systemDataQuery;

}
