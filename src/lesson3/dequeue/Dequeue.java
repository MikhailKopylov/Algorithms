package lesson3.dequeue;

public interface Dequeue<E> {

    boolean insertFirst(E value);
    boolean insertLast(E value);

    E removeFirst();
    E removeLast();

    E peekFirst();
    E peekLast();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
