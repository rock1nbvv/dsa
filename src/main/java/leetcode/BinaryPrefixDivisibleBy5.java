package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/description/">1018. Binary Prefix Divisible By 5</a>
 * <br><br>
 * For each bit(0 or 1)<br>
 * remainder = (remainder << 1<u>(basically - remainder * 2)</u> + b) % 5<br>
 * if current remainder == 0, then current prefix is divisible by 5.
 */
public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
//        IntegerBinaryToDecimal(101);
        System.out.println(prefixesDivBy5(nums));
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            result.add(prefix == 0);
        }
        return result;
    }
}
