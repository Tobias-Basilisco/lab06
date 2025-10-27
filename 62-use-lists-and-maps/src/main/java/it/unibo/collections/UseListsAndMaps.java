package it.unibo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final int READ_ELEMS = 1000;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1000; i < 2000; i++){
            al.addAll(Arrays.asList(i));
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> ll = new LinkedList<>(al);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tempFirst;
        tempFirst = al.get(0);
        al.set(0, al.get(al.size() - 1));
        al.set(al.size() - 1, tempFirst);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : al){
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * Prepare a variable for measuring time
         */
        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            al.set(0, i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " ints in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            ll.set(0, i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " ints in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        int tempInt;
        for (int i = 1; i <= ELEMS; i++) {
            tempInt = al.get(al.size() / 2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + READ_ELEMS
                + " ints from an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            tempInt = ll.get(ll.size() / 2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + READ_ELEMS
                + " ints from a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
