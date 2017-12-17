package com.nickkbright.dijkstra;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public int mark;

    @Override
    public String toString() {
        return "To " + label +
                " = " + mark;
    }

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
        mark = -1;
    }
}