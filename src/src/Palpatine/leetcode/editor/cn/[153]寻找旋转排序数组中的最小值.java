//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (lo <= hi) {
            if (nums[lo] <= nums[hi ]) {
                return nums[lo];
            }
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] < nums[mid]) {
                // 左侧递增，在右边
                lo = mid + 1;
            } else {
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                }

                if (nums[mid] < nums[lo]) {
                    hi = mid;
                }
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
