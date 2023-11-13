package com.sagar.service;



import com.sagar.entities.Match;

import java.util.List;
import java.util.Map;

public interface CricketService {

    List<Match> getLiveMatchScores();
    List<List<String>> getCWC2023PointTable();

    List<Match> getAllMatches();



}