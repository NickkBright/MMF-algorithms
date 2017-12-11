package com.nickkbright.kruskal;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public int set;

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", wasVisited=" + wasVisited +
                ", set=" + set +
                '}';
    }

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
        set = 0;
    }
}
