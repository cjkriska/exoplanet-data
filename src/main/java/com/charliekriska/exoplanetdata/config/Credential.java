package com.charliekriska.exoplanetdata.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "rest-client")
public class Credential {
    private String username;
    private String password;
}
