//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str: strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedArr = Arrays.toString(charArr);
            List<String> tmpV = hashMap.getOrDefault(sortedArr, new ArrayList<>());
            tmpV.add(str);
            hashMap.put(sortedArr, tmpV);
        }
        return new ArrayList<>(hashMap.values());
//        List<List<String>> ret = new ArrayList<>();
//        for (String sortedArr: hashMap.keySet()) {
//            ret.add(hashMap.get(sortedArr));
//        }
//        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
