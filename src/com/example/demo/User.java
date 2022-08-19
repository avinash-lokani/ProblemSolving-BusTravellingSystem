package com.example.demo;

import com.example.demo.constants.Constants;
import com.example.demo.data.BusStationsData;
import com.example.demo.service.BusServiceImpl;

import java.util.Map;
import java.util.Scanner;

public class User {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.HEADING);


        int stationsCount = 0;
        for (int i = 0; i < BusStationsData.stationNames.size() / 10; i++) {
            for (int j = 0; j < BusStationsData.stationNames.size() / 20; j++) {
                System.out.print(BusStationsData.stationNames.get(stationsCount++) + "    ");
            }
            System.out.println();
        }


        System.out.println(Constants.FORMAT_LINE);

        System.out.println(Constants.SOURCE);

        String source = sc.next();

        System.out.println(Constants.DESTINATION);

        String destination = sc.next();


        printResults(source, destination);

    }

    private static void printResults(String source, String destination) {
        if (source.toLowerCase().equals(destination.toLowerCase())) {

            System.out.println(Constants.SAME_STATIONS);

        }
        else if (BusStationsData.stationNames.containsValue(source.toLowerCase()) && BusStationsData.stationNames.containsValue(destination.toLowerCase())) {
            int srcStationNumber = 1, destStationNumber = 1;
            boolean isSource = false, isDestination = false;
            for (Map.Entry<Integer, String> entry : BusStationsData.stationNames.entrySet()) {
                if (entry.getValue().toLowerCase().equals(source.toLowerCase())) {
                    srcStationNumber = entry.getKey();
                    isSource = true;
                }
                if (entry.getValue().toLowerCase().equals(destination.toLowerCase())) {
                    destStationNumber = entry.getKey();
                    isDestination = true;
                }
                if (isSource && isDestination) {
                    BusServiceImpl service = new BusServiceImpl();
                    service.findShortestPath(srcStationNumber, destStationNumber);
                    break;
                }
            }
        }
            else{
            System.out.println(Constants.INVALID_NAMES);
        }
    }
}
