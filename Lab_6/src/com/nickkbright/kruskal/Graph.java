package com.nickkbright.kruskal;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    private static int adjMatrix[][];
    private int vertexCount;
    private int edgeCount;
    private static ArrayList<Edge> sortedEdgeList;
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

    public void sortEdges(){
        sortedEdgeList = new ArrayList<>();
        for (int i = 0; i < edgeList.length; i++) {
            sortedEdgeList.add(edgeList[i]);
        }
        Collections.sort(sortedEdgeList);
        for (int i = 0; i < sortedEdgeList.size(); i++) {
            System.out.println(sortedEdgeList.get(i) + ", ");
        }
    }
//    int mstKruskal(Edge[] edges) {
//        DSF dsf = new DSF(vNum); // СНМ
//        sortEdges(); // Сортируем ребра
//        int ret = 0; // результат
//        for (int i = 0; i < sortedEdgeList.size(); i++) // перебираем ребра в порядке возрастания
//            if (dsf.Unite(edges., e.v)) // если ребра принадлежат разным компонентам
//                ret += e.w; // добавляем вес ребра к стоимости MST
//        return ret;
//    }

    public void addVertex (char lab) {
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

    public void showVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public void showMatrix () {
        System.out.print("\t");
        for (int i = 0; i < vertexCount; i++) {
            showVertex(i);
            System.out.print("\t");
        }
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

    public void findKruskalMST () {
        int setCounter = 1;
        ArrayList<Edge> MSTree = new ArrayList<>();
        for (int i = 0; i < sortedEdgeList.size(); i++) {
            if ((!sortedEdgeList.get(i).start.wasVisited) && (!sortedEdgeList.get(i).end.wasVisited)) {
                sortedEdgeList.get(i).start.wasVisited = true;
                sortedEdgeList.get(i).end.wasVisited = true;
                sortedEdgeList.get(i).start.set = setCounter;
                sortedEdgeList.get(i).end.set = setCounter;
                MSTree.add(sortedEdgeList.get(i));
                setCounter++;
            }
            if ((!sortedEdgeList.get(i).start.wasVisited) || (!sortedEdgeList.get(i).end.wasVisited)) {
                if (sortedEdgeList.get(i).start.set != 0)
                    sortedEdgeList.get(i).end.set = sortedEdgeList.get(i).start.set;
                if (sortedEdgeList.get(i).end.set != 0)
                    sortedEdgeList.get(i).start.set = sortedEdgeList.get(i).end.set;
                sortedEdgeList.get(i).start.wasVisited = true;
                sortedEdgeList.get(i).end.wasVisited = true;
                MSTree.add(sortedEdgeList.get(i));
            }
            if ((sortedEdgeList.get(i).start.wasVisited) && (sortedEdgeList.get(i).end.wasVisited)) {
                if (sortedEdgeList.get(i).start.set != sortedEdgeList.get(i).end.set) {
                    for (int j = 0; j < sortedEdgeList.size(); j++) {
                        if ((sortedEdgeList.get(i).start.set > sortedEdgeList.get(i).end.set)&&(sortedEdgeList.get(i).end.set > 0))
                            sortedEdgeList.get(i).start.set = sortedEdgeList.get(i).end.set;
                        if ((sortedEdgeList.get(i).start.set < sortedEdgeList.get(i).end.set)&&(sortedEdgeList.get(i).start.set > 0))
                            sortedEdgeList.get(i).end.set = sortedEdgeList.get(i).start.set;
                    }
                    MSTree.add(sortedEdgeList.get(i));
                }

            }
        }
        for (int i = 0; i < MSTree.size(); i++) {
            System.out.println(MSTree.get(i) + ", ");
        }

    }




}
