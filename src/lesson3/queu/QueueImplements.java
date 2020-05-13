package lesson3.queu;

import java.util.Objects;

public class QueueImplements<E> implements Queue<E> {

    private E[] arrayData;
    private int size;
    private int headElementIndex;
    private int tailElementIndex;

    @SuppressWarnings("unchecked")
    public QueueImplements(int maxSize) {
        this.size = 0;
        arrayData = (E[]) new Object[maxSize];
        headElementIndex = 0;
        tailElementIndex = -1;
    }

    @Override
    public boolean insert(E value) {

        if (isFull()) {
            return false;
        }
        if (tailElementIndex == arrayData.length - 1) {
            tailElementIndex = -1;
        }

        arrayData[++tailElementIndex] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (headElementIndex == arrayData.length) {
            headElementIndex = 0;
        }
        size--;
        return arrayData[headElementIndex++];
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            return null;
        }
        return arrayData[headElementIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == arrayData.length;
    }
}
