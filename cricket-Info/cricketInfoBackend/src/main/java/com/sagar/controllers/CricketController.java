package com.sagar.controllers;


import com.sagar.entities.Match;
import com.sagar.service.CricketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cricket")
@CrossOrigin("*")
public class CricketController {

    private static final Logger logger = LoggerFactory.getLogger(CricketController.class);

    private CricketService cricketService;

    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @GetMapping("/live")
    public ResponseEntity<?> getLiveMatchScores() throws InterruptedException {
        //System.out.println("getting live match");
        logger.info("getting live match");
        return new ResponseEntity<>(this.cricketService.getLiveMatchScores(), HttpStatus.OK);
    }

    @GetMapping("/point-table")
    public ResponseEntity<?> getCWC2023PointTable() {
        logger.info("getting point table");
        return new ResponseEntity<>(this.cricketService.getCWC2023PointTable(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        logger.info("getting all matches");
        return new ResponseEntity<>(this.cricketService.getAllMatches(), HttpStatus.OK);
    }
}