//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        for (int n : nums) {
//            int size = res.size();
//            for (int i = 0; i < size; i++) {
//                List<Integer> sub = new ArrayList<>(res.get(i));
//                sub.add(n);
//                res.add(sub);
//            }
//        }
//        return res;
//    }



    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return res;
        }
        combination(nums, 0, new Stack<Integer>());
        return res;
    }

    private void combination(int[] nums, int begin, Stack<Integer> pre) {
        res.add(new ArrayList<>(pre));

        for (int i = begin; i < nums.length; i++) {
            pre.push(nums[i]);
            combination(nums, i + 1, pre);
            pre.pop();
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
