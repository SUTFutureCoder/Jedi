//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        combination(nums, used, new Stack<>());
        return new ArrayList<>(res);
    }

    private void combination(int[] nums, boolean[] used, Stack<Integer> pre) {
        if (pre.size() == nums.length) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            pre.push(nums[i]);
            used[i] = true;
            combination(nums, used, pre);
            used[i] = false;
            pre.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
