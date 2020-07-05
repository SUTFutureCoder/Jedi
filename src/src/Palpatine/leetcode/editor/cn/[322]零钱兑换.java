//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1. 
//
// Example 1: 
//
// 
//Input: coins = [1, 2, 5], amount = 11
//Output: 3 
//Explanation: 11 = 5 + 5 + 1 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Note: 
//You may assume that you have an infinite number of each kind of coin. 
// Related Topics 动态规划


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public int coinChange(int[] coins, int amount) {
//        return dp(coins, amount);
//    }
//
//    Map<Integer, Integer> dpMap = new HashMap<>();
//
//    private int dp(int[] coins, int amount) {
//        if (dpMap.containsKey(amount)) {
//            return dpMap.get(amount);
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int lastRes = dp(coins, amount - coin);
//            if (lastRes == -1) {
//                continue;
//            }
////            dpMap.put(amount, Math.min(dpMap.getOrDefault(amount, Integer.MAX_VALUE), lastRes + 1)) ;
//            res = Math.min(res, lastRes + 1);
//        }
//        if (res != Integer.MAX_VALUE) {
//            dpMap.put(amount, res);
//        } else {
//            dpMap.put(amount, -1);
//        }
//        return dpMap.get(amount);
//    }



    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
