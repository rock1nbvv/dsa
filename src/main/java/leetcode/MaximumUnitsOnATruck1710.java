package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">1710. Maximum Units on a Truck</a><br><br>
 * Note: don't forget to break the loop if truck is already full
 */
public class MaximumUnitsOnATruck1710 {
    /**
     * Sane Solution - uses Arrays.sort() and comparator
     */
    static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int totalUnits = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] < truckSize) {
                totalUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                totalUnits += truckSize * boxType[1];
                truckSize -= truckSize;
            }
            if (truckSize == 0) {
                break;
            }
        }
        return totalUnits;
    }

    /**
     * Insane solution - manual implementation of quickSort algorithm using Lomuto partition technique and high element as a pivot.<br> Shows better runtime performance on leetcode
     */
    static int maximumUnitsManualSort(int[][] boxTypes, int truckSize) {
        LomutoPartitionSorter.quickSort(boxTypes, 0, boxTypes.length - 1);
        int totalUnits = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] < truckSize) {
                totalUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                totalUnits += truckSize * boxType[1];
                truckSize -= truckSize;
            }
            if (truckSize == 0) {
                break;
            }
        }
        return totalUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println("Actual " + maximumUnits(boxTypes, truckSize));
        System.out.println("Expected 8");

        System.out.println();

        int[][] boxTypes1 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize1 = 10;
        System.out.println("Actual " + maximumUnitsManualSort(boxTypes1, truckSize1));
        System.out.println("Expected 91");
    }


    static class LomutoPartitionSorter {
        static void swap(int[][] arr, int i, int j) {
            int[] temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        static int partition(int[][] arr, int low, int high) {
            int p = arr[high][1];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j][1] >= p) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        static void quickSort(int[][] arr, int low, int high) {
            if (low < high) {
                int p = partition(arr, low, high);
                quickSort(arr, low, p - 1);
                quickSort(arr, p + 1, high);
            }
        }
    }
}
