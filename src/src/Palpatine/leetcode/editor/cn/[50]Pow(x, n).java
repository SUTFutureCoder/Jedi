//Implement pow(x, n), which calculates x raised to the power n (xn). 
//
// Example 1: 
//
// 
//Input: 2.00000, 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: 2.10000, 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: 2.00000, -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// Note: 
//
// 
// -100.0 < x < 100.0 
// n is a 32-bit signed integer, within the range [−231, 231 − 1] 
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
//        // terminal
//        if (n == 0) {
//            return 1;
//        }
//
//        // drill down
//        if (n < 0) {
//            return 1 / (x * myPow(x, -(n + 1)));
//        }
//
//        if (n % 2 == 0) {
//            return myPow(x * x, n / 2);
//        } else {
//            return x * myPow(x * x, (n - 1) / 2);
//        }


        // terminal
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        // conquer
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);

        // process & revert
        return rest * half * half;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
