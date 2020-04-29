package Lesson2;

import java.util.Arrays;
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
    public void add(E value) {
        if(size >= arrayData.length){
            arrayData = Arrays.copyOf(arrayData, (int) ((int) size * DEGREE_OF_INCREASE));
        }
        arrayData[size] = value;
        size++;

    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (arrayData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        checkVA(index);
        return arrayData[index];
    }


    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        remove(index);
        return false;
    }

    @Override
    public boolean remove(int index) {
        checkVA(index);
        System.arraycopy(arrayData, arrayData.length - 1 - index,
                arrayData, arrayData.length - 2, arrayData.length - size);
        return fals;
    }

    private void checkVA(int index) {
        if(index < 0 || index >= size){
            throw  new IndexOutOfBoundsException("You have gone beyond this array!");
        }
    }
}
