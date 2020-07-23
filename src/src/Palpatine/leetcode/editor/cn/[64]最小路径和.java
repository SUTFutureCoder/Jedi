//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics 数组 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= y; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }

        return dp[x][y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
