//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics 栈 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        Deque<String> tmp = new LinkedList<>();
//        for (String str: s.split("")) {
//            if ("(".equals(str)) {
//                tmp.addFirst(")");
//                continue;
//            }
//            if ("{".equals(str)) {
//                tmp.addFirst("}");
//                continue;
//            }
//            if ("[".equals(str)) {
//                tmp.addFirst("]");
//                continue;
//            }
//            if (!str.equals(tmp.peekFirst())) {
//                return false;
//            }
//            tmp.pollFirst();
//        }
//        return tmp.isEmpty();


        Deque<Character> deque = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c == '(')
                deque.addFirst(')');
            else if (c == '[')
                deque.addFirst(']');
            else if (c == '{')
                deque.addFirst('}');
            else if (deque.isEmpty() || deque.pollFirst() != c)
                return false;
        }
        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
