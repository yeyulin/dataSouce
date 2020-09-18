package com.datasouce.leetcode.onehundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-18
 *         141  环形链表
 */
public class OneHundredAndFortyOne {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OneHundredAndFortyOne oneHundredAndFortyOne = new OneHundredAndFortyOne();
        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(2);
        ListNode i3 = new ListNode(3);
        i1.next = i2;
        i2.next = i3;
        i3.next = i1;
        boolean b = oneHundredAndFortyOne.hasCycle(i1);
        System.out.println(b);
    }

}
