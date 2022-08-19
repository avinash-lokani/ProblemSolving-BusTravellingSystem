package com.example.demo.data;

import com.example.demo.constants.Constants;
import com.example.demo.model.Edge;
import com.example.demo.model.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusStationsData {

    public static final Station  station;
    public static Map<Integer,String> stationNames = new HashMap<>();

     static {
         BufferedReader br;
         File file = new File(Constants.MAP);

        try {
            File stationsList = new File(Constants.STATIONS_LIST);
            br = new BufferedReader(new FileReader(stationsList));
            String st;

            int count = 0;
            while ((st = br.readLine()) != null){
                stationNames.put(count++,st.toLowerCase());

            }

            br.close();

            br = new BufferedReader(new FileReader(file));


            List<Edge> stations = new ArrayList<>();

            while ((st = br.readLine()) != null){
                String[] ar = st.split("\t");
                int source = Integer.parseInt(ar[0]) - 1;
                int destination = 0;
                int cost = 0;
                for(int i = 1;i<ar.length;i++){
                    String[] arr = ar[i].split(",");
                    destination = Integer.parseInt(arr[0]) - 1;
                    cost = Integer.parseInt(arr[1]);
                    stations.add(new Edge(source,destination,cost));
                }

            }
            station = new Station(stations,stationNames.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
