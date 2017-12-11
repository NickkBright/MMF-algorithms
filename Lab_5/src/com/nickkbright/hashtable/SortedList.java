package com.nickkbright.hashtable;

public class SortedList {
    private Link first; // Ссылка на первый элемент списка

    public void SortedList() {
        first = null;
    }

    public void insert(Link link) { // Вставка в порядке сортир
        int key = link.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous==null) // В начале списка
            first = link; // first --> новый элемент
        else // Не в начале
            previous.next = link; // prev --> новый элемент
        link.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public void displayList() {
//        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) { // Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }

    public Link find(int key) { // Поиск элемента с заданным ключом
        Link current = first; // Начиная от начала списка
        // До конца списка
        while(current != null && current.getKey() <= key) { // или пока ключ не превысит current,
            if(current.getKey() == key) // Искомый элемент?
                return current; // Совпадение обнаружено
            current = current.next; // Переход к следующему элементу
        }
        return null; // Элемент не найден
    }
}