//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        combination(nums, new Stack<Integer>());
        return res;
    }

    public void combination(int[] nums, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (stack.contains(nums[i])) {
                continue;
            }
            stack.push(nums[i]);
            combination(nums, stack);
            stack.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
