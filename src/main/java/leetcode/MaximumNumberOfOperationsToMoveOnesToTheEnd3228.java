package leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/">3228. Maximum Number of Operations to Move Ones to the End</a>
 * <br>
 * NOTE: good to know how chars interact. Go through an array, count ones, if we find a case when s[i]=0 and s[i-1]=1 we increment amount of operations by the amount of already counted ones
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd3228 {
    public static int maxOperations(String s) {
        int ops = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            ones += s.charAt(i) - '0';
            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                ops+=ones;
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        String s = "11000";
        System.out.println(maxOperations(s));
    }
}
