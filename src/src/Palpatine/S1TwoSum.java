package Palpatine;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author xingchen.lin
 * @desc
 * @time 2020/1/12 2:52 下午.
 */
public class S1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num: nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(target - nums[i])) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == target - nums[i] && j != i) {
                        System.out.println(i);
                        System.out.println(j);
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

}
