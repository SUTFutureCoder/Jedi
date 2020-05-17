//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int first = 0, last = s.length() - 1;
        char[] charArr = s.toLowerCase().toCharArray();
        while (first <= last) {
            while (!((charArr[first] >= 'a' && charArr[first] <= 'z') || (charArr[first] >= '0' && charArr[first] <= '9')) && first < last) {
                first++;
            }
            while (!((charArr[last] >= 'a' && charArr[last] <= 'z') || (charArr[last] >= '0' && charArr[last] <= '9')) && first < last) {
                last--;
            }
            if (charArr[first] != charArr[last]) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
