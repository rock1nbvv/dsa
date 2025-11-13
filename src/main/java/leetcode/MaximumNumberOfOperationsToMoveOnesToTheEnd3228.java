package leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/">3228. Maximum Number of Operations to Move Ones to the End</a>
 * <br>
 * NOTE: good to know how chars interact. Go through an array, remember each one, and when finding a zero add all counted ones to the result and jump to the next 1
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd3228 {
    public static int maxOperations(String s) {
        int ops = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) =='1'){
                ones ++;
            }else if(s.charAt(i)=='0'){
                ops+=ones;
                while(i<s.length()-1 && s.charAt(i+1)=='0'){
                    i++;
                }
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        String s = "11000";
        System.out.println(maxOperations(s));
    }
}
