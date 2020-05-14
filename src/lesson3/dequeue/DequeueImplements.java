package lesson3.dequeue;


public class DequeueImplements<E> implements Dequeue<E> {

    private final E[] arrayData;
    private int firstElementIndex;
    private int lastElementIndex;
    private int size;

    @SuppressWarnings("unchecked")
    public DequeueImplements(int maxSize) {
        this.size = 0;
        arrayData = (E[]) new Object[maxSize];
        firstElementIndex = maxSize / 2;
        lastElementIndex = maxSize / 2;
    }

    @Override
    public boolean insertFirst(E value) {
        if (isFull()) {
            return false;
        }

        if (firstElementIndex < 0) {
            firstElementIndex = arrayData.length - 1;
        }
        arrayData[firstElementIndex--] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        if (isFull()) {
            return false;
        }

        if (lastElementIndex == arrayData.length - 1) {
            lastElementIndex = -1;
        }
        size++;
        arrayData[++lastElementIndex] = value;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (firstElementIndex == arrayData.length - 1) {
            firstElementIndex = -1;
        }
        size--;

        return arrayData[++firstElementIndex];
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (lastElementIndex < 0) {
            lastElementIndex = arrayData.length - 1;
        }

        size--;
        return arrayData[lastElementIndex--];
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return arrayData[firstElementIndex];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return arrayData[lastElementIndex];
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
