package com.nickkbright.prim;

public class Vertex {
    public char label;
    public boolean wasVisited;

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", wasVisited=" + wasVisited +
                '}';
    }

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}