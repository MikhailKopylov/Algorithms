package Lesson2;

import java.util.Arrays;
import java.util.Objects;


public class ArrayImplements<E extends Object & Comparable<? super E>> implements Array<E> {


    private E[] arrayData;
    private int size;

    public ArrayImplements(E... arrayValue) {

        this.arrayData = arrayValue;
        size = arrayValue.length;
    }

//   Выдаёт ошибку "Error:(22, 27) java: incompatible types: java.util.Objects[] cannot be converted to E[]"
//    Не смог разобраться как исправить.

//    public ArrayImplements() {
//        size = 0;
//        arrayData = (E[]) new Objects[INITIAL_CAPACITY];
//    }
//
//    public ArrayImplements(int size) {
//        this.size = size;
//        arrayData = (E[]) new Objects[size];
//    }


    @Override
    public void add(E value) {
        if (size >= arrayData.length) {
            arrayData = Arrays.copyOf(arrayData, (int) (size * DEGREE_OF_INCREASE));
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
        checkIndex(index);//Проверка границ массива
        return arrayData[index];
    }


    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return (index != -1) && (remove(index) != null);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);//Проверка границ массива
        if (!isEmpty()) {

            E removeElement = arrayData[index];
            int countCopyOfElements = size - index - 1;//количество сдвигаемых элементов
            int startPositionForCopy = index + 1;//позиция первого сдвигаемого элемента

            System.arraycopy(arrayData, startPositionForCopy, arrayData, index, countCopyOfElements);
            size--;
            arrayData[arrayData.length - 1] = null;
            return removeElement;
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(arrayData[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("[");
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + arrayData[i]);
        }
        System.out.println("]");
    }

    @Override
    public void sortBubble() {

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arrayData[i].compareTo(arrayData[j]) > 0) {
                    swapElements(i, j);
                }
            }
        }
    }


    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arrayData[min].compareTo(arrayData[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                swapElements(min, i);
            }
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arrayData[i].compareTo(arrayData[j]) > 0) {
                    E temp = arrayData[i];
                    int countCopyOfElements = i - j - 1;
                    int startPositionForCopy = j + 1;
                    System.arraycopy(arrayData, j, arrayData, startPositionForCopy, countCopyOfElements);
                    arrayData[j] = temp;
                }
            }
        }
    }

    private void swapElements(int firstIndex, int secondIndex) {
        E temp = arrayData[firstIndex];
        arrayData[firstIndex] = arrayData[secondIndex];
        arrayData[secondIndex] = temp;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("You have gone beyond this array!");
        }
    }
}
