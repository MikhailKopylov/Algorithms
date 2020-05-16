package lesson4;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E> {

    LinkedList<E> linkedList;
    LinkedList.Entry<E> nextElement;
    LinkedList.Entry<E> previousElement;

    public LinkedIterator(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
        nextElement = linkedList.getFirstElement();
        previousElement = null;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    @Override
    public E next() {
        previousElement = nextElement;
        nextElement = nextElement.next;
        return previousElement.value;
    }
}
