package com.nickkbright.prim;

public class Graph {
    private static int adjMatrix[][];
    private int vertexCount;
    private int edgeCount;
    private int visitedVertexCount = 0;
    private int MSTWeight = 0;
    private int minWeight;
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
                adjMatrix[i][j] = 0;
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
            System.out.println("\n");
        }
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

    public int findMinWeight (int[][] adjMatrix, int currVertex, int prevVertex) {
        minWeight = 1000000;
        for (int i = 0; i < vertexCount; i++) {
            if (prevVertex == -1) {
                if (i != currVertex){
                    if ((adjMatrix[i][currVertex] < minWeight)&&(adjMatrix[i][currVertex] != 0))
                        minWeight = adjMatrix[i][currVertex];
                }
            }
            else {
                if ((i != currVertex)){
                    if ((adjMatrix[i][currVertex] < minWeight)&&(!vertexList[i].wasVisited)&&(adjMatrix[i][currVertex] != 0))
                        minWeight = adjMatrix[i][currVertex];
                }
            }

        }
        if (minWeight == 1000000) return 0;
        return minWeight;
    }

    public void findPrimMST() {
        int currVertex = 0;
        int prevVertex = -1;
        System.out.print(vertexList[0].label+"->");
        minWeight = findMinWeight(adjMatrix,currVertex,prevVertex);
        for (int j = 0; j < vertexCount; j++) {
            for (int i = 0; i < vertexCount; i++) {
                if (minWeight == 0) {
                    vertexList[currVertex].wasVisited = true;
                    visitedVertexCount++;
                    currVertex = prevVertex;
                    if (visitedVertexCount > vertexList.length)
                        break;
                    System.out.print(vertexList[currVertex].label+"->");

                    minWeight = findMinWeight(adjMatrix,currVertex,prevVertex);
                }
                else {
                    if (adjMatrix[i][currVertex] == minWeight){
                        MSTWeight += adjMatrix[i][currVertex];
                        System.out.print(vertexList[i].label+"->");
                        prevVertex = currVertex;
                        vertexList[prevVertex].wasVisited = true;
                        visitedVertexCount++;
                        currVertex = i;
                        minWeight = findMinWeight(adjMatrix,currVertex,prevVertex);

                    }
                }

            }
        }
        System.out.println();
        System.out.println("Weight: " + MSTWeight);
    }
}