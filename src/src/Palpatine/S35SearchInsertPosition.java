package Palpatine;

/**
 * @author xingchen.lin
 * @desc
 * @time 2020/1/20 9:16 上午.
 */
public class S35SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        // 先二分查找找到位置
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        // 放入位置
        if (nums[end] < target) {
            return end + 1;
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] < target && nums[end] > target) {
            return start + 1;
        }
        return 0;
    }

}
