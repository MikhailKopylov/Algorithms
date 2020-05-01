package lesson3.queu;

public interface Queue<E> {


    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
