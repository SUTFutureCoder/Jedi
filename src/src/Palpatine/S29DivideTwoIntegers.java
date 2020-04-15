package Palpatine;

/**
 * @author xingchen.lin
 * @desc
 * @time 2020/1/20 9:42 上午.
 */
public class S29DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
//        // 求二分查找了几次，只移动end，为2的几次方。最后一次查找观察剩余的数字，乘以几次然后再求
//        int start = 1;
//        int end = dividend;
//        int bintimes = 0;
//        while (start < end - 1) {
//            if (start + (end - start) / 2 <= Math.abs(divisor)) {
//                break;
//            }
//            bintimes++;
//            end = start + (end - start) / 2;
//        }
//        // 最后看end距离divisor有多远
//        int part = end - divisor;
//        int plus = 0;
//        plus = bintimes * part / divisor;
//        System.out.println((int)Math.pow(2, (double) bintimes) + plus);
//        return 0;

        boolean sign = (dividend > 0) ^ (divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int count = 0;
        while (dividend >= divisor) {
            count += 1;
            divisor <<= 1;
        }
        long result = 0L;
        while (count > 0) {
            count -= 1;
            divisor >>= 1;
            if (divisor <= dividend) {
                result += 1 << count;
                dividend -= divisor;
            }
        }
        result = sign ? -1 * result : result;
        return (int)result;
    }

}
