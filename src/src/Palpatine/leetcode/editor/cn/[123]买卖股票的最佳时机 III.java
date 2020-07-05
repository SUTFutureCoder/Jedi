//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), prof
//it = 4-1 = 3. 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
// Related Topics 数组 动态规划


import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//        TreeSet<Integer> max = new TreeSet<>();
//        int i = 0, high = 0, low = 0;
//        while (i < prices.length - 1) {
//            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
//                i++;
//            }
//            low = prices[i];
//            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
//                i++;
//            }
//            high = prices[i];
//            max.add(high - low);
//        }
//        System.out.println(max);
//        return 0;

        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];
        for (int k = 2; k >= 1; k--) {
            dp[0][k][0] = 0;
            dp[0][k][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 0; dp[i][0][1] = Integer.MIN_VALUE;
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][2][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
