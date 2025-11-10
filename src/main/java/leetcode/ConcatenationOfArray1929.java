package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/concatenation-of-array/description/">1929. Concatenation of Array</a>
 */
public class ConcatenationOfArray1929 {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n*2];
        for (int i = 0; i < n; i++) {
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
