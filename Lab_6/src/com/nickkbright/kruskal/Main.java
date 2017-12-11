package com.nickkbright.kruskal;

public class Main {
    private static final int VERTEX_NUMBER = 5;
    private static final int EDGES_NUMBER = 7;
    public static void main (String arg[]) {

        Graph graph = new Graph(VERTEX_NUMBER, EDGES_NUMBER);
        for(int i = 0; i < VERTEX_NUMBER; i++) {

            graph.addVertex((char)(65+i));
        }
        Vertex vertexA = new Vertex('A');
        Vertex vertexB = new Vertex('B');
        Vertex vertexC = new Vertex('C');
        Vertex vertexD = new Vertex('D');
        Vertex vertexE = new Vertex('E');
        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexB, vertexD, 2);
        graph.addEdge(vertexC, vertexE, 2);
        graph.addEdge(vertexC, vertexD, 4);
        graph.addEdge(vertexD, vertexE, 6);
        graph.addEdge(vertexC, vertexA, 5);
        graph.addEdge(vertexA, vertexD, 3);

        graph.showMatrix();

        graph.sortEdges();
        System.out.println();
        graph.findKruskalMST();

    }

}
