package lesson4;

import lesson3.stack.Stack;

public class LinkedStack<E>  implements Stack<E> {

    LinkedList<E> linkedList = new OneSideLinkedList<>();

    @Override
    public boolean push(E value) {
         linkedList.insertFirst(value);
         return true;
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
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
