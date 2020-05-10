//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics 位运算 数组 分治算法


import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int majorityElement(int[] nums) {
        // sort and middle
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        // moore voting
//        int ret = 0, cnt = 0;
//        for (int n : nums) {
//            if (cnt == 0) {
//                ret = n;
//            }
//            if (n != ret) {
//                cnt--;
//            } else {
//                cnt++;
//            }
//        }
//        return ret;

        /// TO SLOW!!!!
        return majorityElementRec(nums, 0, nums.length - 1);

    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;


    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int n: nums) {
            if (n == num) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
