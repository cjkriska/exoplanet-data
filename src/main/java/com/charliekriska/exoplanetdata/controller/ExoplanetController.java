package com.charliekriska.exoplanetdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExoplanetController {

    @GetMapping("/test")
    public String getTest() {
        return "Test";
    }

}
