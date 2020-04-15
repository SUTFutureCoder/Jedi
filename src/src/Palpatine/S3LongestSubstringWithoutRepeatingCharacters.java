package Palpatine;

/**
 * @author xingchen.lin
 * @desc
 * @time 2020/2/8 8:50 上午.
 */
public class S3LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        System.out.println(ans);
        return ans;
    }

}
