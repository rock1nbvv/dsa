package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/keep-multiplying-found-values-by-two/description">2154. Keep Multiplying Found Values by Two</a>
 */
public class KeepMultiplyingFoundValuesByTwo2154 {
    public static int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int value = original;
        while (set.contains(value)){
            value *= 2;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        System.out.println(findFinalValue(nums, original));
    }
}
