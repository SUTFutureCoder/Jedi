//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings. 
//
// 
//
// If there is no common subsequence, return 0. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// The input strings consist of lowercase English characters only. 
// 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1arr = text1.toCharArray();
        char[] text2arr = text2.toCharArray();
//        int[][] map = new int[text1arr.length][text2arr.length];
//        if (text1arr[0] == text2arr[0]) {
//            map[0][0] = 1;
//        }
//        for (int i = 1; i < text1arr.length; i++) {
//            map[i][0] = map[i - 1][0];
//            if (text1arr[i] == text2arr[0]) {
//                map[i][0] = 1;
//            }
//        }
//        for (int j = 1; j < text2arr.length; j++) {
//            map[0][j] = map[0][j - 1];
//            if (text1arr[0] == text2arr[j]) {
//                map[0][j] = 1;
//            }
//        }
//        for (int i = 1; i < text1arr.length; i++) {
//            for (int j = 1; j < text2arr.length; j++) {
//                map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
//                if (text1arr[i] == text2arr[j]) {
//                    map[i][j] = map[i - 1][j - 1] + 1;
//                }
//            }
//        }
//        return map[text1arr.length - 1][text2arr.length - 1];


        int length1 = text1arr.length;
        int length2 = text2arr.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1arr[i - 1] == text2arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
