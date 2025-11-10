package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">217. Contains Duplicate</a><br>
 * NOTE:  Set returns {@code true} if it did not already contain specified element
 */
public class ContainsDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicateSorted(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }
}
