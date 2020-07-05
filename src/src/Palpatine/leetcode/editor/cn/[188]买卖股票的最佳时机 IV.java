//Say you have an array for which the i-th element is the price of a given stock
// on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most k tr
//ansactions. 
//
// Note: 
//You may not engage in multiple transactions at the same time (ie, you must sel
//l the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [2,4,1], k = 2
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: [3,2,6,5,0,3], k = 2
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4.
//             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), prof
//it = 3-0 = 3.
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k > n / 2) {
            return maxProfitInf(prices);
        }
        int [][][] dp = new int[n + 1][k + 1][2];
        for (int i = k; i >= 1; i--) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][k][0];
    }

    private int maxProfitInf(int[] prices) {
        int n = prices.length;
        int dp_0 = 0;
        int dp_1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, dp_0 - prices[i]);
        }
        return dp_0;


    }

}
//leetcode submit region end(Prohibit modification and deletion)
