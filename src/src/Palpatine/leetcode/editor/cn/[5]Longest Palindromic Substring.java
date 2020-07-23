//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2461 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        String maxString = String.valueOf(s.charAt(0));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int length = 1;
                    if (i + 1 == j) {
                        dp[i][j] = true;
                        length = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            length = j - i + 1;
                        }
                    }
                    if (length >= maxLength) {
                        maxString = s.substring(i, i + length);
                        maxLength = length;
                    }
                }
            }
        }
        return maxString;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
