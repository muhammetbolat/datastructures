package org.bolat.util.collection;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class ArrayStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private final T [] array;
    private int size;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int size) {
        array = (T [])new Object[size];
    }

    public boolean push(T item) {
        if ((array.length - size) == 0)
            return false;

        array[array.length - ++size] = item;

        return true;
    }

    public T pop() {
        if (size == 0)
            return null;
        T result = array[array.length - size];
        array[array.length - size--] = null;

        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void walk(Consumer<T> consumer) {
        IntStream.range(array.length - size, array.length).forEach(i -> consumer.accept(array[i]));
    }

    public void filter(Predicate<T> predicate) {
        IntStream.range(array.length - size, array.length).forEach(i -> predicate.test(array[i]));
    }
}
