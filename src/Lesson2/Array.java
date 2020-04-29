package Lesson2;

public interface Array<E> {


    final int INITIAL_CAPACITY = 32;
    final double DEGREE_OF_INCREASE = 1.75;

    void add(E value);

    int indexOf(E value);
    E get(int index);

    boolean remove(E value);
    boolean remove(int index);

}
