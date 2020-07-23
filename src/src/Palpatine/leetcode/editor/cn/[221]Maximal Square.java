//Given a 2D binary matrix filled with 0's and 1's, find the largest square cont
//aining only 1's and return its area. 
//
// Example: 
//
// 
//Input: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics 动态规划 
// 👍 474 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
//            max = Math.max(max, dp[i][0]);
//        }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
//            max = Math.max(max, dp[0][j]);
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = 1;
//                    if (matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                        int before = dp[i - 1][j - 1];
//                        for (int k = 1; k <= before; k++) {
//                            if (matrix[i][j - k] == '0' || matrix[i - k][j] == '0') {
//                                dp[i][j] = 2;
//                            }
//                        }
//                    }
//                    max = Math.max(max, dp[i][j]);
//                }
//            }
//        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
//                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j], dp[i][j + 1])) + 1;
//                    max = Math.max(max, dp[i + 1][j + 1]);
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
