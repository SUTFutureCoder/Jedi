//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics 数组 分治算法 动态规划


import java.util.Arrays;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
//        int preSum = 0, currSum = 0, maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            preSum = currSum;
//            if (preSum < 0) {
//                currSum = nums[i];
//            } else {
//                currSum += nums[i];
//            }
//
//            maxSum = Math.max(currSum, maxSum);
//
////            if (currSum > maxSum) {
////                maxSum = currSum;
////            }
//        }
//        return maxSum;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

//
//            if (dp[i - 1] < 0) {
//                dp[i] = nums[i];
//            } else {
//                dp[i] = dp[i - 1] + nums[i];
//            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
