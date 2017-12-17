package com.nickkbright.dijkstra;

public class Edge {
    public Vertex start;
    public Vertex end;
    public int weight;

    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

}
