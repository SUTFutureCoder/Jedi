//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] sArr = s.split(" ");
        return sArr[sArr.length - 1].length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
