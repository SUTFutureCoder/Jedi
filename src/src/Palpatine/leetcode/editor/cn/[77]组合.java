//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return res;
        }
        helper(n, k, 1, new Stack<>());
        return res;
    }

    private void helper(int n, int k, int begin, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i <= (n - (k - stack.size()) + 1); i++) {
            stack.push(i);
            helper(n, k, i + 1, stack);
            stack.pop();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
