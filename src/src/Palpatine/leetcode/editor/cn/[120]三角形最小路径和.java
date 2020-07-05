//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics 数组 动态规划


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lengthy = triangle.size();
        int lengthx = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[lengthy+1][lengthx+1];

        for (int j = lengthy - 1; j >= 0; j--) {
            for (int i = 0; i < triangle.get(j).size(); i++) {
                dp[j][i] = Math.min(dp[j+1][i], dp[j+1][i+1]) + triangle.get(j).get(i);
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
