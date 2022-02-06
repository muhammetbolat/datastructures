package org.bolat.util.collection;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DLinkedList<T> {
    private int m_size;
    private Node<T> m_head;
    private Node<T> m_tail;

    private static class Node<T> {
        public Node<T> prev;
        public Node<T> next;
        public T elem;
        public Node(T elem) {
            this.elem = elem;
        }

    }
    public DLinkedList() {
        m_size = 0;
    }

    public void addItemTail(T item) {
        Node<T> lastNode = new Node<>(item);

        if (m_tail == null)
            m_head = m_tail = lastNode;
        else {
            lastNode.prev = m_tail;
            m_tail.next = lastNode;
            m_tail = lastNode;
        }
        m_size++;
    }

    public void addItemHead(T item) {
        Node<T> firstNode = new Node<>(item);

        if (m_head == null)
            m_head = m_tail = firstNode;
        else {
            Node<T> secondNode = m_head;
            m_head = firstNode;
            firstNode.next = secondNode;
            secondNode.prev = firstNode;
        }
        m_size++;
    }

    public T removeHead() {
        if (m_head == null)
            return null;
        T oldVal = m_head.elem;
        if (m_head == m_tail)
            m_head = m_tail = null;
        else {
            m_head = m_head.next;
            m_head.prev = null;
        }
        m_size--;

      return oldVal;
    }

    public T removeTail() {
        if (m_tail == null)
            return null;
        T oldTail = m_tail.elem;
        if (m_tail == m_head)
            m_tail = m_head = null;
        else {
            m_tail = m_tail.prev;
            m_tail.next = null;
        }
        m_size--;

        return oldTail;
    }
    public void clearFromHead() {
        while (m_head != null)
            removeHead();
    }

    public void clearFromTail() {
        while (m_tail != null)
            removeTail();
    }
    public int size() { return m_size; }

    public void walkList(Consumer<T> consumer) {
        for(Node<T> node = m_head; node != null; node = node.next)
            consumer.accept(node.elem);
    }

    public void walkListReversed(Consumer<T> consumer) {
        for (Node<T> node = m_tail; node != null; node = node.prev)
            consumer.accept(node.elem);
    }

    public Optional<T> walkList(Predicate<T> predicate) {
        for (Node<T> node = m_head; node != null; node = node.next)
            if (predicate.test(node.elem))
                return Optional.of(node.elem);
        return Optional.empty();
    }

    public Optional<T> walkListReversed(Predicate<T> predicate) {
        for (Node<T> node = m_tail; node != null; node = node.prev)
            if (predicate.test(node.elem))
                return Optional.of(node.elem);
        return Optional.empty();
    }

}
