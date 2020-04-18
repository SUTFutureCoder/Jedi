//Given a non-empty array of digits representing a non-negative integer, plus on
//e to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
//        int carry = 0;
//        int len = digits.length - 1;
//        int[] answer = new int[digits.length];
//        digits[len] = ++digits[len] % 10;
//        if (digits[len] == 0) {
//            carry = 1;
//        }
//        int nineNum = 0;
//        for (int digit: digits) {
//            if (digit == 9) {
//                nineNum++;
//            }
//        }
//        if (nineNum == digits.length) {
//            answer = new int[digits.length + 1];
//            answer[0] = 1;
//        }
//        while (carry == 1) {
//            len--;
//            digits[len] = ++digits[len] % 10;
//            if (digits[len] != 0) {
//                break;
//            }
//        }
//        return answer;

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumbers = new int[n + 1];
        newNumbers[0] = 1;
        return newNumbers;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
