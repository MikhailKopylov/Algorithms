package lesson3;

import lesson3.dequeue.Dequeue;
import lesson3.dequeue.DequeueImplements;
import lesson3.queu.Queue;
import lesson3.queu.QueueImplements;
import lesson3.stack.Stack;
import lesson3.stack.StackImplements;

import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class Main3 {

    public static final int MAX_SIZE = 5;

    public static void main(String[] args) {

        stack();

        queue();

        reverseString();

        dequeue();

    }

    private static void dequeue() {
        Dequeue dequeue = new DequeueImplements(5);

        dequeue.insertFirst(1);
        dequeue.insertFirst(2);
        dequeue.insertFirst(3);

        dequeue.insertLast(4);
        dequeue.insertLast(5);
        System.out.println(dequeue.removeLast());
//        System.out.println(dequeue.removeFirst());
        dequeue.insertLast(6);
        dequeue.insertLast(10);

        while (!dequeue.isEmpty()) {
            System.out.println(dequeue.removeLast());
//            System.out.println(dequeue.removeFirst());
        }
        System.out.println(dequeue.removeLast());
    }

    private static void reverseString() {

        String sourceString = "Скажи-ка, дядя, ведь не даром Москва, спаленная пожаром, французу отдана?";

        System.out.println(sourceString);

        Stack stack = new StackImplements(sourceString.length());

        sourceString.chars()
                .mapToObj(c -> (char) c)
                .forEach(stack::push);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void queue() {
        Queue queue = new QueueImplements(MAX_SIZE);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        System.out.println("queue: " + queue.remove());
        queue.insert(5);
        queue.insert(6);
        System.out.println("queue: " + queue.remove());
        queue.insert(7);

        while (!queue.isEmpty()) {
            System.out.println("queue: " + queue.remove());
        }
        System.out.println("queue: " + queue.remove());
    }

    private static void stack() {
        Stack stack = new StackImplements(MAX_SIZE);

        for (int i = 0; i < MAX_SIZE; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println("stack: " + stack.pop());
        }
    }
}
