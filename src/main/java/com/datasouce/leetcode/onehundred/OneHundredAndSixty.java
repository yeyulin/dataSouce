package com.datasouce.leetcode.onehundred;

import com.datasouce.leetcode.ListNode;

/**
 * @author yeyulin 2020-11-24
 *         160 相交链表
 */
public class OneHundredAndSixty {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        ListNode pA = headA;
        ListNode pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        int i=0;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        System.out.println(i);
        return pB;
    }

    public static void main(String[] args) {
        OneHundredAndSixty oneHundredAndSixty=new OneHundredAndSixty();
        ListNode head5=new ListNode(5);
        ListNode head4=new ListNode(4,head5);
        ListNode head8=new ListNode(8,head4);

        ListNode headA1=new ListNode(1,head8);
        ListNode headA=new ListNode(4,headA1);


        ListNode headB1=new ListNode(1,head8);
        ListNode headB6=new ListNode(6,headB1);
        ListNode headB=new ListNode(5,headB6);
        ListNode intersectionNode = oneHundredAndSixty.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);

    }

}
