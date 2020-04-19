//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
//
// Example: 
//
// 
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.
// 
//
// 
// Related Topics 栈 设计


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

//    LinkedList<Integer> s = new LinkedList<>();
//    ArrayList<Integer> min = new ArrayList<>();
//    int len;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//    }
//
//    public void push(int x) {
//        s.addFirst(x);
//
//        if (min.size() == 0 || min.get(len-1) > x ) {
//            min.add(len, x);
//        } else {
//            min.add(len, min.get(len-1));
//        }
//        len++;
//    }
//
//    public void pop() {
//        s.pollFirst();
//        min.remove(--len);
//    }
//
//    public int top() {
//        return s == null ? 0 : s.peekFirst();
//    }
//
//    public int getMin() {
//        return min.get(len - 1);
//    }

    Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    private class Node {

        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this(val, min, null);
        }

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
