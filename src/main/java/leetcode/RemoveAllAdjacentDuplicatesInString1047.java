package leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/">1047. Remove All Adjacent Duplicates In String</a>
 */
public class RemoveAllAdjacentDuplicatesInString1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
