package com.nickkbright.hashtable;

public class Link {
    private int iData; // Данные
    public Link next; // Следующий элемент списка

    public Link(int it) {
        iData= it;
    }

    public void displayLink() {
        System.out.print( "->" + iData);
    }

    public int getKey() {
        return iData;
    }
}