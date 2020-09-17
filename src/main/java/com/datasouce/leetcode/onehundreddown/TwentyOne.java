package com.datasouce.leetcode.onehundreddown;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-16
 *         21 合并两个有序链表
 */
public class TwentyOne {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode result = new ListNode();
        if (l1.val > l2.val) {
            result.val = l2.val;
            l2 = l2.next;
        } else {
            result.val = l1.val;
            l1 = l1.next;
        }
        //暂存头部引用
        ListNode dummyHead = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                break;
            } else if (l2 == null) {
                result.next = l1;
                break;
            } else if (l1.val > l2.val) {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            //自己指向下一个引用
            result = result.next;
        }
        return dummyHead;
    }

    public static void main(String[] args) {
        TwentyOne twentyOne = new TwentyOne();
        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(2);
        ListNode i3 = new ListNode(3);
        i1.next = i2;
        i2.next = i3;
        ListNode q1 = new ListNode(1);
        ListNode q2 = new ListNode(3);
        ListNode q3 = new ListNode(4);
        q1.next = q2;
        q2.next = q3;
        ListNode node = twentyOne.mergeTwoLists(i1, q1);
        System.out.println(node);

    }

}
