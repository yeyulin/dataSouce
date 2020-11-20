package com.datasouce.leetcode.onehundreddown;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-11-20
 *         给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *         如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *         您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *         示例：
 *         输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *         输出：7 -> 0 -> 8
 *         原因：342 + 465 = 807
 *         //TODO 重写
 */
public class Two {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (result == null) {
                tail = new ListNode(sum % 10);
                result = tail;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        Two two = new Two();
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1=new ListNode(2);
        ListNode l12=new ListNode(4);
        ListNode l13=new ListNode(3);
        l1.next=l12;
        l12.next=l13;

        ListNode l23=new ListNode(4);
        ListNode l22=new ListNode(6,l23);
        ListNode l2=new ListNode(5,l22);
        ListNode node = two.addTwoNumbers(l1, l2);
        System.out.println(node);
    }

}
