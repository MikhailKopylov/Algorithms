package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main3 {

    public static void main(String[] args) {
        Integer[] array = new Integer[1000000];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(new String[]{i + ": " + array[i]}));
        }
    }


}
