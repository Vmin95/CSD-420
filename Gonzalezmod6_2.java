/*
 * Julia Gonzalez
 * 6/29/2025
 * CSD420
 */

import java.util.Comparator;

public class Gonzalezmod6_2 {

    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 4, 2, 7, 9, 6, 8, 1, 10};

        System.out.println("Original Array:");
        displayArray(numbers);

        // Sort with Comparable
        bubbleSort(numbers);
        System.out.println("Sorted using Comparable:");
        displayArray(numbers);

        // Reset array for comparator sort
        Integer[] numbersForComparator = {5, 3, 4, 2, 7, 9, 6, 8, 1, 10};

        // Sort with Comparator
        bubbleSort(numbersForComparator, new IntegerCompare());
        System.out.println("Sorted using Comparator:");
        displayArray(numbersForComparator);
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean didSwap;

        do {
            didSwap = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    swap(list, i, i + 1);
                    didSwap = true;
                }
            }
        } while (didSwap);
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean hasChanged;

        do {
            hasChanged = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    swap(list, i, i + 1);
                    hasChanged = true;
                }
            }
        } while (hasChanged);
    }

    private static <E> void swap(E[] array, int idx1, int idx2) {
        E temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static <E> void displayArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// Separate class implementing Comparator for Integer
class IntegerCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}
