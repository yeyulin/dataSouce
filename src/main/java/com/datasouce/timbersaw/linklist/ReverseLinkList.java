package com.datasouce.timbersaw.linklist;

/**
 * @author yeyulin
 * @description: 6 反转
 * @date 2020/7/28 9:06
 **/
public class ReverseLinkList {

    public Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public Node reserve2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        //保存上一次链表的值
        Node pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            //从新赋值pre
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Node reverse3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        Node pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Node reverse4(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Node reverse5(Node head) {
        Node cur = head;
        Node result = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;

        } return result;
    }


    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        System.out.println(l1);
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        Node reverse = reverseLinkList.reverse(l1);
        System.out.println(reverse);
        Node reverse2 = reverseLinkList.reverse5(reverse);
        System.out.println(reverse2);
    }

}
