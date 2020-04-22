//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics 排序 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>(16);
        for (Character c: s.toCharArray()) {
            Integer former = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++former);
        }
        for (Character c: t.toCharArray()) {
            Integer cInt = hashMap.getOrDefault(c, 0);
            if (--cInt < 0) {
                return false;
            }
            if (cInt == 0) {
                hashMap.remove(c);
            } else {
                hashMap.put(c, cInt);
            }
        }
        return hashMap.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
