package leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/description/">3542. Minimum Operations to Convert All Elements to Zero</a>
 * <br>
 * NOTE: use monotonic increasing stack. Every
 */
public class MinimumOperationsToConvertAllElementsToZero3542 {
    public static int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }
            if (n == 0) {
                continue;
            }
            if (stack.isEmpty() || stack.peek() < n) {
                res++;
                stack.push(n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 1};
        System.out.println(minOperations(nums));
    }
}
