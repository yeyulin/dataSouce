package com.datasouce.timbersaw.linklist;

/**
 * @author yeyulin
 * @description: 反转
 * @date 2020/7/28 9:06
 **/
public class ReverseLinkList {

    public ListNode reverse(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public ListNode reserve2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = null;
        //保存上一次链表的值
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            //从新赋值pre
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        System.out.println(l1);
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        ListNode reverse = reverseLinkList.reverse(l1);
        System.out.println(reverse);
        ListNode reverse2 = reverseLinkList.reserve2(reverse);
        System.out.println(reverse2);

        while (reverse.getNext() != null) {
            System.out.println(reverse.getVal());
            reverse = reverse.getNext();
        }
    }
}
