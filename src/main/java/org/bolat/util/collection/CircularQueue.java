package org.bolat.util.collection;


import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("ALL")
public class CircularQueue<T> {
    private static final int DEFAULT_SIZE = 10;
    private final T [] array;
    private int head;
    private int tail;
    private int size;
    public CircularQueue(int size) {
        array = (T [])new Object[size];

    }
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public boolean putItem(T item) {
        if (size == array.length)
            return false;
        array[tail++] = item;
        tail %= array.length;
        size++;
        return true;
    }

    public Optional<T> getItem() {

        if (size == 0)
            return Optional.empty();

        Optional<T> val = Optional.ofNullable(array[head++]);
        size--;

        return val;
    }

    public Optional<T> findFirst(Predicate<T> predicate) {
        Optional<T> result;
        if ((tail - head) > 0)
            result = Arrays.stream(array, head, tail).filter(predicate).findFirst();
        else {
            result = Arrays.stream(array, head, array.length).filter(predicate).findFirst();
            if (result.isEmpty())
                result = Arrays.stream(array, 0, tail).filter(predicate).findFirst();
        }
        return result;
    }

    public Optional<T> findLast(Predicate<T> predicate) {
        Optional<T> result;
        if ((tail - head) > 0)
            result = Arrays.stream(array, head, tail).filter(predicate).reduce((r, s) -> s);
        else {
            result = Arrays.stream(array, head, array.length).filter(predicate).reduce((r, s) -> s);
            if (result.isEmpty())
                result = Arrays.stream(array, 0, tail).filter(predicate).reduce((r, s) -> s);
        }
        return result;
    }

    public int size() { return size; }

    public void walk(Consumer<T> consumer) {
        if ((tail - head) > 0)
            Arrays.stream(array, head, tail).forEach(consumer);
        else {
            Arrays.stream(array, head, array.length).forEach(consumer);
            Arrays.stream(array, 0, tail).forEach(consumer);
        }
    }

}
