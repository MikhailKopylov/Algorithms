package lesson4;

import lesson3.queu.Queue;

public class LinkedQueue<E> implements Queue<E> {
    private TwoSideLinkedList<E> linkedList = new TwoSideLinkedListImpl();

    @Override
    public boolean insert(E value) {
        linkedList.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return  linkedList.removeFirst();
    }

    @Override
    public E peekFront() {
        return linkedList.getFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
