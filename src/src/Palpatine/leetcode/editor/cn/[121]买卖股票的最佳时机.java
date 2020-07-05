//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        int minPos = -1;
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (min > prices[i]) {
//                min = prices[i];
//                minPos = i;
//            }
//        }
//        if (minPos == prices.length - 1) {
//            return 0;
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = minPos; i < prices.length; i++) {
//            if (max < prices[i]) {
//                max = prices[i];
//            }
//        }
//        return max - min;
//
//        int curMax = 0, maxSoFar = 0;
//        for (int i = 1; i < prices.length; i++) {
//            curMax = Math.max(0, curMax += prices[i] - prices[i - 1]);
//            maxSoFar = Math.max(maxSoFar, curMax);
//        }
//        return maxSoFar;
        if (prices.length == 0) {return 0;}
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
