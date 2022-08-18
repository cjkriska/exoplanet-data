package com.charliekriska.exoplanetdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExoplanetController {

    @GetMapping("/test")
    public String getTest() {
        return "https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,hostname,pl_letter,discoverymethod,disc_year,pl_orbper,pl_orbsmax,pl_rade,pl_bmasse,pl_dens,pl_orbeccen,pl_eqt,sy_dist+from+pscomppars+order+by+sy_dist+asc&format=json";
    }

}
