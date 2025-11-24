package leetcode;

/**
 * <a href="https://leetcode.com/problems/greatest-sum-divisible-by-three/description/">1262. Greatest Sum Divisible by Three</a>
 */
public class GreatestSumDivisibleByThree1262 {
    public static int maxSumDivThree(int[] nums) {
        int total = 0;
        int smallest_one = 100_000;
        int smallest_two = 100_000;
        for (int n : nums) {
            total += n;
            if (n % 3 == 1) {
                smallest_two = Math.min(smallest_two, n + smallest_one);
                smallest_one = Math.min(smallest_one, n);
            } else if (n % 3 == 2) {
                smallest_one = Math.min(smallest_one, n + smallest_two);
                smallest_two = Math.min(smallest_two, n);
            }
        }

        if (total % 3 == 1) {
            return total - smallest_one;
        } else if (total % 3 == 2) {
            return total - smallest_two;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 36, 8, 32, 38, 3, 30, 13, 40};
        System.out.println(maxSumDivThree(nums));
    }
}
