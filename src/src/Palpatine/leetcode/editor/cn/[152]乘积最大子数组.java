//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int imax = nums[0], imin = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = imax;
            imax = Math.max(Math.max(nums[i], imax * nums[i]), imin * nums[i]);
            imin = Math.min(Math.min(nums[i], t * nums[i]), imin * nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
