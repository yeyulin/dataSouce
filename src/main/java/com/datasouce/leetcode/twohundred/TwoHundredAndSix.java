package com.datasouce.leetcode.twohundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-15
 *         206 反转链表
 */
public class TwoHundredAndSix {

    public ListNode reverseList(ListNode head) {
        //当前针节点
        ListNode cur = head;
        //前指针节点
        ListNode prev = null;
        //当前指针不为null，将当前指针指向它前面的节点，然后当前节点和前节点后移
        while (cur != null) {
            //临时节点
            ListNode node = cur.next;
            //当前指针的下一个节点为之前的前置节点，反转
            cur.next = prev;
            //反转完成，赋值前置节点
            prev = cur;
            //将临时节点赋值给当前节点，继续循环
            cur = node;

        }
        return prev;
    }

    public static void main(String[] args) {
        TwoHundredAndSix twoHundredAndSix = new TwoHundredAndSix();
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        System.out.println(node);
        ListNode node4 = twoHundredAndSix.reverseList(node);
        System.out.println(node4);
    }

}
