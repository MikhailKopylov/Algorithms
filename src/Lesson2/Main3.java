package Lesson2;

import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main3 {

    private static final int ARRAY_SIZE = 20000;

    public static void main(String[] args) {
        Integer[] array = new Integer[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt();
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(Arrays.toString(new String[]{i + ": " + array[i]}));
//        }


        Array<Integer> arraySortBubble = new ArrayImplements<>(Arrays.copyOf(array, array.length));

        long startBubble = System.nanoTime();
        arraySortBubble.sortBubble();
        long endBubble = System.nanoTime();
        long resultBubble = TimeUnit.NANOSECONDS.toMillis(endBubble) - TimeUnit.NANOSECONDS.toMillis(startBubble);

        System.out.println("Bubble: " + resultBubble + " msec");
//        arraySortBubble.display();

        Array<Integer> arraySortSelect = new ArrayImplements<>(Arrays.copyOf(array, array.length));

        long startSelect = System.nanoTime();
        arraySortSelect.sortSelect();
        long endSelect = System.nanoTime();
        long resultSelect = TimeUnit.NANOSECONDS.toMillis(endSelect) - TimeUnit.NANOSECONDS.toMillis(startSelect);

        System.out.println("Select: " + resultSelect + " msec");
//        arraySortSelect.display();

        Array<Integer> arraySortInsert = new ArrayImplements<>(Arrays.copyOf(array, array.length));

        long startInsert = System.nanoTime();
        arraySortInsert.sortSelect();
        long endInsert = System.nanoTime();
        long resultInsert = TimeUnit.NANOSECONDS.toMillis(endInsert) - TimeUnit.NANOSECONDS.toMillis(startInsert);

        System.out.println("Insert: " + resultInsert + " msec");
//        arraySortInsert.display();

    }


}
