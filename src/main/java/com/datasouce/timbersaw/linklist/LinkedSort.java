package com.datasouce.timbersaw.linklist;

/**
 * @author yeyulin
 * @description: 10 单链表排序
 * @date 2020/7/31 8:31
 **/
public class LinkedSort {
    public static Node quickSort(Node head) {
        //边界值判断
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        int temp = 0;
        while (cur != null) {
            int curData = cur.val;
            Node next = cur.next;
            while (next != null) {
                int val = next.val;
                if (curData > val) {
                    temp = curData;
                    curData = val;
                    val = temp;
                    cur.val = curData;
                    next.val = val;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        Node node = quickSort(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
