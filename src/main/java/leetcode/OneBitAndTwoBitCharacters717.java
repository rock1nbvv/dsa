package leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters/description/">717. 1-bit and 2-bit Characters</a>
 */
public class OneBitAndTwoBitCharacters717 {
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length>1) {
            boolean res=false;
            for (int i = 0; i < bits.length-1; i++) {
                if(bits[i]==1){
                    i++;
                    res=false;
                } else if(bits[i]==0){
                    res=true;
                }
            }
            return res;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }
}
