package org.bolat.util.collection;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Vector<T> extends AbstractList<T> implements List<T>, RandomAccess, Cloneable, Serializable {
    private final static int DEFAULT_CAPACITY = 10;
    private T [] m_elems;
    private int m_index;

    private void checkIndexOfBound(int index) {
        if (index < 0 || index >= m_index)
            throw new ArrayIndexOutOfBoundsException("Invalid value: index < 0 || index >= m_index:" +  index);

    }
    @SuppressWarnings("unchecked")
    public Vector() {
        m_elems = (T []) new Object[DEFAULT_CAPACITY];
    } 
    public Vector(int initialCapacity) {
        throw new UnsupportedOperationException();
    }
    public Vector(int initialCapacity, int capacityIncrement) {

    }
    public Vector(Collection<? extends T> collection) {

    }

    public int capacity() {
        return m_elems.length;
    }

    @Override
    public int size() {
        return m_index;
    }

    @Override
    public T get(int index) {
        checkIndexOfBound(index);
        return m_elems[index];
    }


    public T set(int index, T value) {
        checkIndexOfBound(index);
        T old = m_elems[index];
        m_elems[index] = value;
        return old;
    }



    ////////////////////////


    @Override
    public void forEach(Consumer<? super T> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> stream() {
        return super.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return super.parallelStream();
    }



    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
       throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vector<T> clone() throws CloneNotSupportedException {
        return (Vector<T>) super.clone();
    }
}
