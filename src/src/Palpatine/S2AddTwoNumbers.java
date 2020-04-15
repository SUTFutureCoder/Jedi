package Palpatine;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author xingchen.lin
 * @desc
 * @time 2020/1/14 7:25 上午.
 */
public class S2AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode previous = null;
        ListNode head = null;
        int add = 0;
        do {
            ListNode l3;
            int plus = add;
            if (l1 != null) {
                plus += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                plus += l2.val;
                l2 = l2.next;
            }
            add = 0;
            l3 = new ListNode(plus);
            if (plus > 9) {
                int left = plus % 10;
                l3 = new ListNode(left);
                add = 1;
            }
            if (previous == null) {
                previous = l3;
                head = previous;
            } else {
                previous.next = l3;
                previous = previous.next;
            }
        }
        while (l1 != null && l2 != null || add == 1);
        return head;
    }

}
