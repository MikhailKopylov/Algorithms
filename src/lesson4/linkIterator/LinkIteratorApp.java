package lesson4.linkIterator;

public class LinkIteratorApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertAfter("Petr", 18);
        itr.insertAfter("Vasya", 18);
        itr.insertAfter("Polina", 18);
        list.display();

        itr.nextLink();
        System.out.println();
        System.out.println(itr.getCurrent().name);

        itr.reset();
        System.out.println();
        System.out.println(itr.getCurrent().name);

        System.out.println();
    }

}
