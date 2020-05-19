package lesson3.stack;

public class StackImplements<E> implements Stack<E> {

    private E[] dataArray;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public StackImplements(int maxSize) {
        dataArray = (E[]) new Object[maxSize];
        this.maxSize = maxSize;
        size = 0;
    }

    @Override
    public boolean push(E value) {
        if(!isFull()){
            dataArray[size] = value;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        E removedValue = dataArray[size - 1];
        dataArray[--size] = null;
        return  removedValue;

    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return  dataArray[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }
}
