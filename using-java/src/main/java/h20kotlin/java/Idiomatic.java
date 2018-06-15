package h20kotlin.java;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Idiomatic {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 0, 60, 3, 6, 4, 30, 190);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 3 == 0) {
                System.out.println(number / 3);
            }
        }

        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            if (number % 3 == 0) {
                System.out.println(number / 3);
            }
        }

        for (Integer number : numbers) {
            if (number % 3 == 0) {
                System.out.println(number / 3);
            }
        }

        numbers.stream()
                .filter(number -> number % 3 == 0)
                .map(number -> number / 3)
                .forEach(System.out::println);
    }
}
