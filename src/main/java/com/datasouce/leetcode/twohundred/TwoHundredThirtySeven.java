package com.datasouce.leetcode.twohundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-09-11
 *         237 删除链表中的节点
 */
public class TwoHundredThirtySeven {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(4);
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(9);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        System.out.println(node);
        TwoHundredThirtySeven twoHundredThirtySeven=new TwoHundredThirtySeven();
        twoHundredThirtySeven.deleteNode(node1);
        System.out.println(node);
    }

}
