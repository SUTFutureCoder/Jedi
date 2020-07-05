//Given a word, you need to judge whether the usage of capitals in it is right o
//r not. 
//
// We define the usage of capitals in a word to be right when one of the followi
//ng cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//Otherwise, we define that this word doesn't use capitals in a right way.
//
// 
//
// Example 1: 
//
// 
//Input: "USA"
//Output: True
// 
//
// 
//
// Example 2: 
//
// 
//Input: "FlaG"
//Output: False
// 
//
// 
//
// Note: The input will be a non-empty word consisting of uppercase and lowercas
//e latin letters. 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i]  <= 'Z') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
