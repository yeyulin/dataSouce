package com.datasouce.leetcode.threehundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-11-23
 *         328 奇偶链表
 *         结点1作为奇数链的头 结点2作为偶数链的头
 *         从第3个点开始遍历，依次轮流附在奇、偶链的后面
 *         遍历完后，奇数链的尾连向偶链的头，偶链的尾为空， 返回奇数链的头
 */
public class ThreeHundredAndTwentyEight {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //奇数
        ListNode oddListNode = new ListNode(head.val);
        ListNode tempOddListNode = oddListNode;
        //偶数
        ListNode evenListNode = new ListNode(head.next.val);
        ListNode tempEvenListNode = evenListNode;
        ListNode listNode = head.next.next;
        int i = 3;
        while (listNode != null) {
            if (i % 2 == 0) {
                tempEvenListNode.next = new ListNode(listNode.val);
                tempEvenListNode=tempEvenListNode.next;
            } else {
                tempOddListNode.next = new ListNode(listNode.val);
                tempOddListNode=tempOddListNode.next;
            }
            i++;
            listNode = listNode.next;
        }
        tempOddListNode.next = evenListNode;
        return oddListNode;
    }

    public static void main(String[] args) {
        ThreeHundredAndTwentyEight threeHundredAndTwentyEight=new ThreeHundredAndTwentyEight();
        ListNode node5=new ListNode(5);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        System.out.println(node1);
        ListNode node = threeHundredAndTwentyEight.oddEvenList(node1);
        System.out.println(node);
    }

}
