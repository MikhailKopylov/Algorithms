package Lesson2;

import java.util.Objects;

public class ArrayImplements<E> implements Array<E> {



    private E []arrayData;
    private int size;

    public ArrayImplements(E[] arrayValue) {
        this.arrayData = arrayValue;
        size = arrayValue.length;
    }

    public ArrayImplements() {
        this(INITIAL_CAPACITY);
    }

    public ArrayImplements(int size) {
        this.size = size;
        arrayData = (E[]) new Objects[size];
    }


    @Override
    public boolean add(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
