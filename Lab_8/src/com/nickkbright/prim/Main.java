package com.nickkbright.prim;

public class Main {
    private static final int VERTEX_NUMBER = 6;
    private static final int EDGES_NUMBER = 9;
    public static void main (String arg[]) {

        Graph graph = new Graph(VERTEX_NUMBER, EDGES_NUMBER);
        for(int i = 0; i < VERTEX_NUMBER; i++) {

            graph.addVertex((char)(65+i));
        }
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');


        graph.addEdge(A, B, 1);
        graph.addEdge(B, D, 2);
        //graph.addEdge(C, E, 3);
        graph.addEdge(C, D, 5);
        graph.addEdge(D, E, 4);
        graph.addEdge(C, A, 6);
        //graph.addEdge(A, D, 3);
        graph.addEdge(D, F, 3);
       // graph.addEdge(E, F, 1);


        graph.showMatrix();
        graph.findPrimMST();

    }

}
