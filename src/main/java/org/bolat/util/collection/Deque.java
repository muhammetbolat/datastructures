package org.bolat.util.collection;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Deque<T> {
    private static final int defaultCapacity = 10;
    private enum Position{ HEAD, TAIL}
    private int size;
    private T [] items;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Deque(int capacity) {
        if (capacity <= 0)
            throw new IndexOutOfBoundsException("Initial capacity should be higher than 0.");

        items = (T []) new Object[capacity];
        head = tail = capacity / 2;
    }

    public Deque() {
        this(defaultCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public Optional<T> getItemFirst() {
        return size() == 0 ? Optional.empty(): Optional.of(items[head]);
    }

    public Optional<T> getItemTail() {
        return size() == 0 ? Optional.empty(): Optional.of(items[tail]);
    }

    public T getItem(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index should be index < 0 || index > size. ");

        return items[head + index];
    }

    public void clear() {
        IntStream.range(head, tail).forEach(i -> items[i] = null);
        head = tail = items.length / 2;
        size = 0;
    }

    public void addItemFirst(T item) {
        if (head == 0)
            capacityManagement(Position.HEAD);

        // ...
        items[--head] = item;
        size++;
    }

    public void addItemTail(T item) {
        if (tail == items.length )
            capacityManagement(Position.TAIL);

        items[tail++] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void capacityManagement(Position position) {
        T [] newArray = (T []) new Object[items.length * 2];

        if (position == Position.HEAD) {
            System.arraycopy(items, 0, newArray, items.length, tail);
            head += items.length;
            tail += items.length;
        }
        else
            System.arraycopy(items, head, newArray, head, size);

        items = newArray;
    }

    public void walk(Consumer<T> consumer) {
        IntStream.range(head, tail).forEach(i -> consumer.accept(items[i]));
    }
}
