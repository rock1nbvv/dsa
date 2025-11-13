package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description/">242. Valid Anagram</a><br>
 * NOTE: a-z chars have sequential codes
 */
public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        if (!(s.length() == t.length())) {
            return false;
        }
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();
        Arrays.sort(sA);
        Arrays.sort(tA);
        return Arrays.equals(sA, tA);
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagramCharFreq(s1, t1));
        String s2 = "rat", t2 = "car";
        System.out.println(isAnagramCharFreq(s2, t2));
    }

    public static boolean isAnagramCharFreq(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int c : freq) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
