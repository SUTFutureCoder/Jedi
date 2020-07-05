//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int wlo = 0, whi = matrix[0].length - 1;
        int hlo = 0, hhi = matrix.length - 1, hanx = hlo;
        // 锁定位置
        while (hlo <= hhi) {
            int hmid = hlo + (hhi - hlo) / 2;
            if (matrix[hmid][0] == target) {
                return true;
            }
            if (matrix[hmid][0] >= target) {
                hhi = hmid - 1;
            } else {
                hlo = hmid + 1;
                hanx = hmid;
            }
        }

        while (wlo <= whi) {
            int wmid = wlo + (whi - wlo) / 2;
            if (matrix[hanx][wmid] == target) {
                return true;
            }
            if (matrix[hanx][wmid] >= target) {
                whi = wmid - 1;
            } else {
                wlo = wmid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
