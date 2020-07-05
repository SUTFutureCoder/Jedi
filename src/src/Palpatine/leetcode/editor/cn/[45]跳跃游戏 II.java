//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics 贪心算法 数组


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] table = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int s = 0; s <= nums[i] && i + s < nums.length; s++) {
                if (i == 0) {
                    table[i + s] = 1;
                } else if (table[i + s] == 0){
                    // 如果之前已经有值，则不赋值
                    table[i + s] = table[i] + 1;
                }
            }
        }
        return table[nums.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
