//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics 位运算


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
