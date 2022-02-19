package org.bolat.util.collection;

import java.util.Optional;

public class LinkedListQueue<T> {
    private final DoublyLinkedList<T> doublyLinkedList = new DoublyLinkedList<>();

    public T getItem() {
        Optional<T> result = doublyLinkedList.getItemHead();
        doublyLinkedList.removeHead();
        return result.orElse(null);
    }
    public void putItem(T elem) {
        doublyLinkedList.addItemTail(elem);
    }
    public int size() {
        return doublyLinkedList.size();
    }

    public void clear() {
        doublyLinkedList.clear();
    }
}
