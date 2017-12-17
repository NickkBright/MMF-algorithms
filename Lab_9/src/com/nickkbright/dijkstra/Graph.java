package com.nickkbright.dijkstra;

public class Graph {
    private static int adjMatrix[][];
    private int vertexCount;
    private int edgeCount;
    private int minMark;
    private int vertexIndex;
    private static Edge edgeList[];
    private static Vertex vertexList[];

    public Graph(int VertexNumber, int EdgesNumber) {
        vertexList = new Vertex[VertexNumber];
        edgeList = new Edge[EdgesNumber];
        vertexCount = 0;
        edgeCount = 0;
        adjMatrix = new int[VertexNumber][VertexNumber];
        for (int i = 0; i < VertexNumber; i++) {
            for (int j = 0; j < VertexNumber; j++) {
                if (i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = -1;
            }
        }
    }

    public void showVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public void showMatrix () {
        System.out.println();
        for (int i = 0; i < vertexCount; i++) {
            showVertex(i);
            System.out.print("\t");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int labelToNumber (char label) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertexList[i].label == label){
                vertexIndex = i;
                break;
            }
        }
        return vertexIndex;
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(Vertex start, Vertex end, int weight) {
        int vertexFrom = 0, vertexTo = 0;
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].label == start.label) {
                vertexFrom = i;
            }
            if (vertexList[i].label == end.label) {
                vertexTo = i;
            }
        }
        adjMatrix[vertexFrom][vertexTo] = weight;
        adjMatrix[vertexTo][vertexFrom] = weight;
        edgeList[edgeCount++] = new Edge(start, end, weight);
    }

    public int findVertexMinimalMark (int vertexIndex) {
        minMark = 10000;
        for (int i = 0; i < vertexCount; i++) {
            if ((!vertexList[i].wasVisited) && (vertexList[i].mark > 0))
                if (vertexList[i].mark < minMark){
                    minMark = vertexList[i].mark;
                    vertexIndex = i;
                }

        }
        return vertexIndex;
    }

    public void markNeighbourVertex (int[][] adjMatrix, int vertexIndex) {
        for (int i = 0; i < vertexCount; i++) {
            if ((i != vertexIndex)) {
                if ((!vertexList[i].wasVisited) && (adjMatrix[i][vertexIndex] != -1)){
                    if (vertexList[i].mark == -1)
                        vertexList[i].mark = vertexList[vertexIndex].mark + adjMatrix[i][vertexIndex];
                    else {
                        if ( (vertexList[vertexIndex].mark + adjMatrix[i][vertexIndex]) < vertexList[i].mark)
                            vertexList[i].mark = vertexList[vertexIndex].mark + adjMatrix[i][vertexIndex];
                    }
                }
            }
        }
        vertexList[vertexIndex].wasVisited = true;
    }

    public void findLeastDistance(char label) {
        System.out.println("\n\tThe least distance from vertex "+label+" to other vertexes:");
        vertexIndex = labelToNumber(label);
        vertexList[vertexIndex].mark = 0;
        for (int i = 0; i < vertexCount; i++) {
           markNeighbourVertex(adjMatrix, vertexIndex);
           vertexIndex = findVertexMinimalMark(vertexIndex);
        }
        for (int i = 0; i < vertexCount; i++) {
            if (vertexList[i].label!=label)
                System.out.println(vertexList[i]);
        }

    }
}