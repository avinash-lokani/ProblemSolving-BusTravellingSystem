package com.example.demo.service;

import static com.example.demo.data.BusStationsData.station;
import static com.example.demo.data.BusStationsData.stationNames;

public class BusServiceImpl implements BusService{

    public void findShortestPath(int source, int destination){
        ShortestPathImpl shortestPath = new ShortestPathImpl();
        shortestPath.findShortestPaths(station,source,destination,stationNames.size());
    }

}
