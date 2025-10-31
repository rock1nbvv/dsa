package algorithms.sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Quick Sort Algorithm Documentation
 *
 * <p>Quick Sort is a recursive, divide-and-conquer sorting algorithm. It partitions the input
 * array into two subarrays and recursively sorts them. It is generally fast in practice but
 * has a quadratic worst-case time complexity if poor pivot choices are made.</p>
 *
 * <h3>Complexity</h3>
 * <table border="1">
 *     <tr><th>Case</th><th>Time</th><th>Space</th></tr>
 *     <tr><td>Best</td><td>O(n log n)</td><td>O(log n)</td></tr>
 *     <tr><td>Average</td><td>O(n log n)</td><td>O(log n)</td></tr>
 *     <tr><td>Worst</td><td>O(n²)</td><td>O(n)</td></tr>
 * </table>
 *
 * <p>Quick Sort is <strong>not stable</strong>.
 * In Java, {@link java.util.Arrays#sort(int[])} uses Dual-Pivot QuickSort for primitive
 * types and{@link java.util.Arrays#sort(Object[] a)} uses TimSort.</p>
 *
 * <h3>Algorithm Overview</h3>
 * <p><strong>Base case:</strong> a subarray of size ≤ 1 is already sorted.</p>
 * <ol>
 *     <li><strong>Choose a pivot</strong> (strategy may vary)</li>
 *     <li><strong>Partition the array</strong> into two regions:</li>
 *     <ul>
 *         <li>Lomuto: left {@code <= pivot}, right {@code > pivot}</li>
 *         <li>Hoare: left {@code <= pivot}, right {@code >= pivot}</li>
 *     </ul>
 *     <li><strong>Recursively sort</strong> both partitions</li>
 * </ol>
 *
 * <h3>Pivot Selection Strategies</h3>
 * <ul>
 *     <li>Random pivot</li>
 *     <li>Median-of-Three (first, middle, last → select median)</li>
 *     <li>Last element</li>
 *     <li>First element</li>
 * </ul>
 *
 * <h3>Partitioning Techniques</h3>
 * <p>Two widely used approaches:</p>
 * <ul>
 *     <li><strong>Lomuto</strong> – simpler implementation, more swaps, pivot placed in final position</li>
 *     <li><strong>Hoare</strong> – fewer swaps, pivot position not guaranteed</li>
 * </ul>
 */

public class QuickSort {
    static Random random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 1, 2, 12, 9, 7, 10, 6};
        HoaresSorter.quickSort(arr1, 0, arr1.length - 1);
        for (int a : arr1) {
            System.out.printf(a + " ");
        }

        System.out.println();

        int[] arr2 = {5, 13, 6, 9, 10, 12, 11, 8};
        LomutoSorter.quickSort(arr2, 0, arr2.length - 1);
        for (int a : arr2) {
            System.out.printf(a + " ");
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int pivotMedianOfThree(int[] array, int low, int high) {
        int a = array[low];
        int b = array[(high - low) / 2];
        int c = array[high];
        if (a < b) {
            if (b < c) {
                return b;
            }
            return a < c ? c : a;
        } else {
            if (a < c) {
                return a;
            }
            return b < c ? c : b;
        }
    }

    /**
     * <h4>Lomuto Partition – Steps</h4>
     * <ol>
     *     <li>Select pivot as {@code arr[high]}</li>
     *     <li>Initialize index {@code i = low - 1}</li>
     *     <li>Scan from {@code low} to {@code high - 1}</li>
     *     <li>If {@code arr[j] <= pivot}: increment {@code i} and swap {@code arr[i]} with {@code arr[j]}</li>
     *     <li>Place pivot in its final position by swapping {@code arr[i + 1]} with {@code arr[high]}</li>
     *     <li>Return the pivot’s final index {@code i + 1}</li>
     * </ol>
     * <p>Recursive calls:</p>
     * <pre>{@code
     * quickSort(arr, low, p - 1)
     * quickSort(arr, p + 1, high)
     * }</pre>
     */
    static class LomutoSorter {
        static int partition(int[] array, int low, int high) {
            int p = array[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] <= p) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high);
            return i + 1;
        }

        static void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int p = partition(array, low, high);
                quickSort(array, low, p - 1);
                quickSort(array, p + 1, high);
            }
        }
    }

    /**
     * <h4>Hoare Partition – Steps</h4>
     * <ol>
     *     <li>Select pivot (typically random or median-of-three)</li>
     *     <li>Initialize two indexes: {@code i = low - 1}, {@code j = high + 1}</li>
     *     <li>Move {@code i} right until reaching an element {@code >= pivot}</li>
     *     <li>Move {@code j} left until reaching an element {@code <= pivot}</li>
     *     <li>If {@code i < j}: swap elements and continue</li>
     *     <li>If {@code i >= j}: return {@code j} — partitioning complete</li>
     * </ol>
     * <p>Recursive calls:</p>
     * <pre>{@code
     * quickSort(arr, low, p)
     * quickSort(arr, p + 1, high)
     * }</pre>
     *
     * <p>Hoare’s partition does <strong>not</strong> guarantee that the pivot ends up at index {@code p}.</p>
     */
    static class HoaresSorter {
        static int partition(int[] array, int low, int high) {
            int p = array[random.nextInt(low, high + 1)];
            int i = low - 1;
            int j = high + 1;
            while (true) {
                do {
                    i++;
                } while (array[i] < p);
                do {
                    j--;
                } while (array[j] > p);
                if (i >= j) {
                    return j;
                }
                swap(array, i, j);
            }
        }

        static void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int p = partition(array, low, high);
                quickSort(array, low, p);
                quickSort(array, p + 1, high);
            }
        }
    }
}
