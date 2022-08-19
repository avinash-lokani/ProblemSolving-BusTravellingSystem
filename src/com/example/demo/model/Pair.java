package com.example.demo.model;

public class Pair {

    private int sNumber;
    private int cost;

    public Pair(int sNumber, int cost) {
        this.cost = cost;
        this.sNumber = sNumber;
    }

    public int getsNumber() {
        return sNumber;
    }

    public int getCost() {
        return cost;
    }

}
