package lesson4;

public class TwoSideLinkedListImpl<E> extends OneSideLinkedList<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement;


    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Entry<E> entry = new Entry<>(value);

        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }

        lastElement = entry;
        size++;
    }


    @Override
    public E getLast() {
        return lastElement.value;
    }
}
