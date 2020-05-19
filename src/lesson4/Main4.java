package lesson4;

import lesson3.stack.Stack;

public class Main4 {
    public static void main(String[] args) {

        oneSideLinkedListTest();

        linkedStackTest();

        twoSideLinkedListTest();

        linkedQueueTest();

        linkedListIterator();


    }

    private static void linkedListIterator() {
        LinkedList<Integer> linkedList = new OneSideLinkedList<>();

        for (int i = 1; i < 10; i++) {
            linkedList.insertFirst(i);
        }

        linkedList.display();
        System.out.println();
        for (Integer value :linkedList) {
            System.out.println(value);
        }
    }

    private static void linkedQueueTest() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        for (int i = 0; i < 15; i++) {
            linkedQueue.insert(i);
        }
        System.out.println(linkedQueue.remove());
        System.out.println();
        System.out.println(linkedQueue.peekFront());
    }

    private static void twoSideLinkedListTest() {
        TwoSideLinkedList<Integer> twoSideLinkedList = new TwoSideLinkedListImpl<>();

        for (int i = 0; i < 10; i++) {
            twoSideLinkedList.insertFirst(i);
            twoSideLinkedList.insertLast(i);
        }

        twoSideLinkedList.display();
        System.out.println();
        System.out.println(twoSideLinkedList.getLast());
    }

    private static void linkedStackTest() {
        Stack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    private static void oneSideLinkedListTest() {
        LinkedList<Integer> linkedList = new OneSideLinkedList<>();

        for (int i = 1; i < 10; i++) {
            linkedList.insertFirst(i);
        }

        linkedList.display();

        System.out.println();
        linkedList.removeFirst();
        System.out.println();

        linkedList.remove(5);
        System.out.println();
        System.out.println(linkedList.getFirstElement());
        System.out.println();
        System.out.println(linkedList.getFirst());
        System.out.println();
        linkedList.display();
    }
}
