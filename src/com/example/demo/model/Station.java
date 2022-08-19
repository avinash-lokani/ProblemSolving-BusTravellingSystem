package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Station {

    private List<List<Edge>> adjList = null;

    public List<List<Edge>> getAdjList() {
        return adjList;
    }

    public Station(List<Edge> edges, int n){
        adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for (Edge edge : edges){
            adjList.get(edge.getSource()).add(edge);
        }
    }

}
