package com.nickkbright.hashtable;

public class HashTable {
    private SortedList[] hashArray; // Массив списков
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // Создание массива
        for (int j=0; j<arraySize; j++) { // Заполнение массива
            hashArray[j] = new SortedList(); // списками
        }
    }

    public void displayTable() {
        for (int j=0; j<arraySize; j++) { // Для каждой ячейки
            System.out.print(j + ": "); // Вывод номера ячейки
            hashArray[j].displayList(); // Вывод списка
        }
    }

    public int hashFunc(int key) { // Хеш-функция
        return key % 113;
    }

    public void insert(Link link) { // Вставка элемента
        int key = link.getKey();
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].insert(link); // Вставка в позиции hashVal
    }

    public void delete(int key) { // Удаление элемента
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].delete(key); // Удаление
    }

    public Link find(int key) { // Поиск элемента
        int hashVal = hashFunc(key); // Хеширование ключа
        Link link = hashArray[hashVal].find(key); // Поиск
        return link; // Метод возвращает найденный элемент
    }
}