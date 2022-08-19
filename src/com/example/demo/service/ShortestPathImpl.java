package com.example.demo.service;

import com.example.demo.constants.Constants;
import com.example.demo.data.BusStationsData;
import com.example.demo.model.Edge;
import com.example.demo.model.Pair;
import com.example.demo.model.Station;

import java.util.*;

public class ShortestPathImpl implements ShortestPathService {

    public void getRoute(int[] prev, int i, List<String> route)
    {
        if (i >= 0)
        {
            getRoute(prev, prev[i], route);
            route.add(BusStationsData.stationNames.get(i));
        }
    }

    public  void findShortestPaths(Station graph, int source, int destination, int n)
    {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.getCost()));
        minHeap.add(new Pair(source, 0));

        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        dist.set(source, 0);


        boolean[] done = new boolean[n];
        done[source] = true;
        int[] prev = new int[n];
        prev[source] = -1;
        while (!minHeap.isEmpty())
        {
            Pair node = minHeap.poll();

            int u = node.getsNumber();

            for (Edge edge: graph.getAdjList().get(u))
            {
                int v = edge.getDestination();
                int weight = edge.getWeight();
                if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Pair(v, dist.get(v)));
                }
            }

            done[u] = true;
        }

        List<String> route = new ArrayList<>();


        if (destination != source && dist.get(destination) != Integer.MAX_VALUE)
        {
                getRoute(prev, destination, route);
                System.out.printf(Constants.PATH_FORMAT,
                        BusStationsData.stationNames.get(source), BusStationsData.stationNames.get(destination), dist.get(destination), route);
                route.clear();
        }
    }

}
