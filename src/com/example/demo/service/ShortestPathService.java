package com.example.demo.service;

import com.example.demo.model.Station;

import java.util.List;

public interface ShortestPathService {
    void findShortestPaths(Station graph, int source, int destination, int n);
    void getRoute(int[] prev, int i, List<String> route);
}
