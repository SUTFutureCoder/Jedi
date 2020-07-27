//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics 字符串 回溯算法 
// 👍 1188 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            res.add(s);
            return;
        }
        if (open < max) {
            backTrack(res, s + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(res, s + ")", open, close + 1, max);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
