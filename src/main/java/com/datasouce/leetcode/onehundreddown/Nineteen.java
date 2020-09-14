package com.datasouce.leetcode.onehundreddown;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-14
 *         19  删除链表的倒数第N个节点
 *         快慢两个节点
 *         快节点先走需要删除的前几步，然后慢节点在继续，
 *         快节点快速走完，此时慢节点刚好走到需要删除的节点
 */
public class Nineteen {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Nineteen nineteen=new Nineteen();
        ListNode node=new ListNode(4);
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(9);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        System.out.println(node);
        nineteen.removeNthFromEnd(node,3);
        System.out.println(node);
    }

}
