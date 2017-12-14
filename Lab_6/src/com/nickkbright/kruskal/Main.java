package com.nickkbright.kruskal;

public class Main {
    private static final int VERTEX_NUMBER = 6;
    private static final int EDGES_NUMBER = 9;
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
        Vertex vertexF = new Vertex('F');


        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexB, vertexD, 2);
        graph.addEdge(vertexC, vertexE, 3);
        graph.addEdge(vertexC, vertexD, 4);
        graph.addEdge(vertexD, vertexE, 5);
        graph.addEdge(vertexC, vertexA, 5);
        graph.addEdge(vertexA, vertexD, 3);
        graph.addEdge(vertexD, vertexF, 4);
        graph.addEdge(vertexE, vertexF, 1);

        graph.showMatrix();

        graph.sortEdges();
        System.out.println();
        graph.findKruskalMST();

    }

}
