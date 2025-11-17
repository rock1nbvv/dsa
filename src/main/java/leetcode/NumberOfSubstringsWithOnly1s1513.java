package leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-substrings-with-only-1s/description/">1513. Number of Substrings With Only 1s</a><br>
 * NOTE: each consecutive 1 increases the amount of sub-strings in sequence by its index
 */
public class NumberOfSubstringsWithOnly1s1513 {
    public static int numSub(String s) {
        int res = 0;
        int consecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                consecutive++;
                res = (res + consecutive) % 1_000_000_007;
            } else {
                consecutive = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
    }
}
