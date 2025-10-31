package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville">3289. The Two Sneaky Numbers of Digitville</a><br><br>
 * Use {@link java.util.HashMap#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)} to increment value in a map.<br>
 * Use {@link Stream#mapToInt(ToIntFunction)} to convert stream on Integers into stream of primitive ints.
 */
public class TheTwoSneakyNumbersOfDigitville3289 {
    static int[] getSneakyNumbersMap(int[] nums) {
        HashMap<Integer, Integer> numberOccurrenceMap = new HashMap<>();
        for (int num : nums) {
            numberOccurrenceMap.merge(num, 1, Integer::sum);
        }
        return numberOccurrenceMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    static int[] getSneakyNumbersSmart(int[] nums) {
        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result[count] = nums[i];
                    count++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
        int[] sneakyNumbers = getSneakyNumbersSmart(arr);
        System.out.printf("Actual %d,%d%n", sneakyNumbers[0], sneakyNumbers[1]);
        System.out.println();
        System.out.print("Expected 4,5");
    }
}
