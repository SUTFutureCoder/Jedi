//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics 回溯算法 
// 👍 471 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] str = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                str[i][j] = '.';
            }
        }
        backTrack(res, str, 0);
        return res;
    }

    private void backTrack(List<List<String>> res, char[][] str, int colIndex) {
        if (colIndex == str.length) {
            List<String> tmpListStr = new ArrayList<>();
            for (int i = 0; i < colIndex; i++) {
                tmpListStr.add(String.valueOf(str[i]));
            }
            res.add(tmpListStr);
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (isValid(str, i, colIndex)) {
                str[i][colIndex] = 'Q';
                backTrack(res, str, colIndex + 1);
                str[i][colIndex] = '.';
            }
        }

    }

    private boolean isValid(char[][] str, int x, int colIndex) {
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < colIndex; j++) {
                if (str[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(colIndex - j) || x == i)) {
                    return false;
                }
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
