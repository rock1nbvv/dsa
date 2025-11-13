package leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/">2654. Minimum Number of Operations to Make All Array Elements Equal to 1</a>
 * NOTE: find minimal sub-array that can have gcd 1
 */
public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualToOne2654 {
    public static int minOperations(int[] nums) {
        int oneCount = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 1) {
                oneCount++;
            }
            curr = gcdIter(curr, num);
        }
        if (oneCount > 0) {
            return nums.length - oneCount;
        }
        if (curr != 1) {
            return -1;
        }

        int minSubLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int x = 0;
            for (int j = i; j < nums.length; j++) {
                if (j - i + 1 > minSubLength) {
                    break;
                }
                x = gcdIter(x, nums[j]);
                if (x == 1) {
                    minSubLength = j - i + 1;
                    break;
                }
            }
        }

        return minSubLength - 1 + nums.length - 1;
    }

    static int gcdIter(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }

    static int gcdRec(int a, int b) {
        if (a == 0)
            return b;
        return gcdRec(b % a, a);
    }


    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 4};
        int[] nums1 = {2, 10, 6, 14};
        int[] nums2 = {6, 10, 15};
        System.out.println(minOperations(nums));
        System.out.println(minOperations(nums1));
        System.out.println(minOperations(nums2));
    }
}
