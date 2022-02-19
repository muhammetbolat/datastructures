package org.bolat.util.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> curNode;
            @Override
            public boolean hasNext() {
                curNode = curNode == null ? head: curNode.next;
                return curNode != null;
            }

            @Override
            public T next() {
                if (curNode == null)
                    throw new NoSuchElementException("No such element in list");

                return curNode.elem;
            }
        };
    }

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private final T elem;
        public Node(T elem) {
            this.elem = elem;
        }

    }
    public DoublyLinkedList() {
        size = 0;
    }

    public void addItemTail(T item) {
        Node<T> lastNode = new Node<>(item);

        if (tail == null)
            head = tail = lastNode;
        else {
            lastNode.prev = tail;
            tail.next = lastNode;
            tail = lastNode;
        }
        size++;
    }

    public void addItemHead(T item) {
        Node<T> firstNode = new Node<>(item);

        if (head == null)
            head = tail = firstNode;
        else {
            Node<T> secondNode = head;
            head = firstNode;
            firstNode.next = secondNode;
            secondNode.prev = firstNode;
        }
        size++;
    }

    public int indexOf(T item) {
        Node<T> curNode = head;
        if (item != null) {
            for (int i = 0; curNode != null; curNode = curNode.next, ++i)
                if (curNode.elem.equals(item))
                    return i;
        }
        else {
            for (int i = 0; curNode != null; curNode = curNode.next, ++i)
                if (curNode.elem == null)
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(T item) {
        Node<T> curNode = tail;
        if (item != null) {
            for (int i = size - 1; curNode != null; curNode = curNode.prev, i--) {
                if (curNode.elem.equals(item))
                    return i;
            }
        }
        else {
            for (int i = size - 1; curNode != null; curNode = curNode.prev, i--) {
                if (curNode.elem == null)
                    return i;
            }
        }
        return -1;
    }

    public T removeHead() {
        if (head == null)
            return null;
        T oldVal = head.elem;
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;

      return oldVal;
    }

    public T removeTail() {
        if (tail == null)
            return null;
        T oldTail = tail.elem;
        if (tail == head)
            tail = head = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;

        return oldTail;
    }

    public T deleteItem(int index) {
        if (index < 0 || index >= size || head == null)
            throw new ArrayIndexOutOfBoundsException("Index must be index < 0 || index >= m_size");

        if (index == 0)
            return removeHead();
        else if (index == size - 1)
            return removeTail();
        else {
            Node<T> curNode = head;

            for (int i = 0; i < index; i++, curNode = curNode.next);

            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            size--;
            return curNode.elem;
        }
    }

    public void clearFromHead() {
        while (head != null)
            removeHead();
    }

    public void clearFromTail() {
        while (tail != null)
            removeTail();
    }
    public void clear() {
        for (Node<T> node = head; node !=  null; node = node.next)
            node.prev = null;

        head = tail = null;
        size = 0;
    }
    public int size() { return size; }

    public void walkList(Consumer<T> consumer) {
        for(Node<T> node = head; node != null; node = node.next)
            consumer.accept(node.elem);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Optional<T> getItemHead() {
        return isEmpty() ? Optional.empty(): Optional.of(head.elem);
    }

    public Optional<T> getItemTail() {
        return isEmpty() ? Optional.empty(): Optional.of(tail.elem);
    }

    public T get(int index) {
        if (head == null || index < 0 || index >= size())
            throw new IllegalArgumentException("Invalid index");

        Node<T> curNode = head;

        for (int i = 0; i < index; i++, curNode = curNode.next);

        return curNode.elem;
    }

    public void insertItem(int pos, T value) {
        if (head == null || pos < 0 || pos > size)
           throw new IndexOutOfBoundsException("Invalid index");
        Node<T> curNode = head;

        for (int i = 0; i < pos; i++, curNode = curNode.next);

        Node<T> newNode = new Node<>(value);
        newNode.next = curNode.next;
        curNode.next = newNode;
        newNode.prev = curNode;

        size++;
    }

    public void walkListReversed(Consumer<T> consumer) {
        for (Node<T> node = tail; node != null; node = node.prev)
            consumer.accept(node.elem);
    }

    public Optional<T> walkList(Predicate<T> predicate) {
        for (Node<T> node = head; node != null; node = node.next)
            if (predicate.test(node.elem))
                return Optional.of(node.elem);
        return Optional.empty();
    }

    public Optional<T> walkListReversed(Predicate<T> predicate) {
        for (Node<T> node = tail; node != null; node = node.prev)
            if (predicate.test(node.elem))
                return Optional.of(node.elem);
        return Optional.empty();
    }

}
