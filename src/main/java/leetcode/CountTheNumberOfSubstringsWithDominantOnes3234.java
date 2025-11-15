package leetcode;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/description/">3234. Count the Number of Substrings With Dominant Ones</a>
 */
public class CountTheNumberOfSubstringsWithDominantOnes3234 {
    public static int numberOfSubstrings(String s) {
        int[] dp = new int[s.length() + 1];
        java.util.Arrays.fill(dp, -1);

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == '0')
                dp[i + 1] = i;
            else
                dp[i + 1] = dp[i];
        }

        int res = 0;

        for (int i = 1; i <= s.length(); i++) {
            int zeroes = (s.charAt(i - 1) == '0') ? 1 : 0;
            int j = i;

            while (j > 0 && zeroes * zeroes <= s.length()) {
                int ones = (i - dp[j]) - zeroes;
                if (zeroes * zeroes <= ones) {
                    res += Math.min(j - dp[j], ones - zeroes * zeroes + 1);
                }
                j = dp[j];
                zeroes++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "0";
        System.out.println(numberOfSubstrings(s));
    }
}
