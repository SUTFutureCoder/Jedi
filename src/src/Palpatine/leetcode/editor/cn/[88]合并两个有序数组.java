//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is greater or equal to 
//m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 高位回溯
        int i = 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[nums1.length - i++] = nums2[--n];
            } else {
                nums1[nums1.length - i++] = nums1[--m];
            }
        }
        while (m > 0) {
            nums1[nums1.length - i++] = nums1[--m];
        }
        while (n > 0) {
            nums1[nums1.length - i++] = nums2[--n];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
