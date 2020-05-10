//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics 字符串 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, List<String>> digitLetterMap = new HashMap<>();

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        initDigitLetterMap();
        String[] splited = digits.split("");
        combination(splited, 0, new Stack<>());
        return res;
    }

    private void combination(String[] splited, int begin, Stack<String> pre) {
        // terminate
        if (splited == null || splited.length == 0)  {
            return;
        }
        if (pre.size() == splited.length) {
            StringBuilder str = new StringBuilder();
            for (int s = 0; s < pre.size(); s++) {
                str.append(pre.get(s));
            }
            res.add(str.toString());
            return;
        }

        List<String> letter = digitLetterMap.get(splited[begin]);
        for (int j = 0; j < letter.size(); j++) {
            pre.push(letter.get(j));
            combination(splited, begin + 1, pre);
            pre.pop();
        }
    }

    private void initDigitLetterMap() {
        digitLetterMap.put("2", Arrays.asList("a", "b", "c"));
        digitLetterMap.put("3", Arrays.asList("d", "e", "f"));
        digitLetterMap.put("4", Arrays.asList("g", "h", "i"));
        digitLetterMap.put("5", Arrays.asList("j", "k", "l"));
        digitLetterMap.put("6", Arrays.asList("m", "n", "o"));
        digitLetterMap.put("7", Arrays.asList("p", "q", "r", "s"));
        digitLetterMap.put("8", Arrays.asList("t", "u", "v"));
        digitLetterMap.put("9", Arrays.asList("w", "x", "y", "z"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
