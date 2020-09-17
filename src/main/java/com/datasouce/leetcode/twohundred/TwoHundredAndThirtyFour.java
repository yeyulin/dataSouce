package com.datasouce.leetcode.twohundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-17
 *         234 回文链表
 */
public class TwoHundredAndThirtyFour {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针，先到中间
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        ListNode prev = null;
        //反转slow
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(1);
        node.next=node2;
//        node2.next=node3;
//        node3.next=node4;
        TwoHundredAndThirtyFour twoHundredAndThirtyFour=new TwoHundredAndThirtyFour();
        boolean palindrome = twoHundredAndThirtyFour.isPalindrome(node);
        System.out.println(palindrome);
    }

}
