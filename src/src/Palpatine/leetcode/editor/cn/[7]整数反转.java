//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics 数学


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
//        int mod = 10;
//        int lastMod = 0;
//        Queue<Integer> stack = new ArrayDeque<>();
//        stack.add(x % mod - lastMod);
//        while (x % mod != x) {
//            lastMod = (x % mod);
//            mod *= 10;
//            stack.add((x % mod - lastMod) * 10 / mod);
//        }
//        int i = 0;
//        while (!stack.isEmpty()) {
//            i += stack.poll() * Math.pow(10, stack.size());
//        }
//        return i;


        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
