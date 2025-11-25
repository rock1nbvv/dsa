package leetcode;

/**
 * <a href="https://leetcode.com/problems/smallest-integer-divisible-by-k/description/">1015. Smallest Integer Divisible by K</a>
 */
public class SmallestIntegerDivisibleByK1015 {
    public static void main(String[] args) {
        int k = 3;
        System.out.println(smallestRepunitDivByK(k));
    }

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int remainder = 1 % k;
        int i = 1;
        while (remainder != 0) {
            i++;
            remainder = (remainder * 10 + 1) % k;
        }
        return i;
    }
}
