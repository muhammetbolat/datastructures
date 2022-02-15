package org.bolat.util.collection;

import java.util.Optional;

public class LinkedListQueue<T> {
    private final DLinkedList<T> dLinkedList = new DLinkedList<>();

    public T getItem() {
        Optional<T> result = dLinkedList.getItemHead();
        dLinkedList.removeHead();
        return result.orElse(null);
    }
    public void putItem(T elem) {
        dLinkedList.addItemTail(elem);
    }
    public int size() {
        return dLinkedList.size();
    }

    public void clear() {
        dLinkedList.clear();
    }
}
