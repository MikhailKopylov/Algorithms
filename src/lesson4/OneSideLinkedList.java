package lesson4;

import java.util.Iterator;

public class OneSideLinkedList<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;

    }

    @Override
    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }

        E removedValue = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previouseElement = null;
        Entry<E> removedElement = firstElement;
        while (removedElement != null) {
            if (removedElement.value.equals(value)) {
                break;
            }
            previouseElement = removedElement;
            removedElement = removedElement.next;
        }
        if (removedElement == null) {
            return false;
        } else if (removedElement.equals(firstElement)) {
            removeFirst();
        } else {
            previouseElement.next = removedElement.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> removedElement = firstElement;
        while (removedElement != null) {
            if (removedElement.value.equals(value)) {
                return true;
            }
            removedElement = removedElement.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Entry<E> printElement = firstElement;
        while (printElement != null) {
            System.out.println(printElement.value);
            printElement = printElement.next;
        }
    }

    @Override
    public E getFirst() {
        return firstElement.value;
    }

    @Override
    public Entry<E> getFirstElement() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator<>(this);
    }
}
