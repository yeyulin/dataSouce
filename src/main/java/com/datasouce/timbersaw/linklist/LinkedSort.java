package com.datasouce.timbersaw.linklist;

/**
 * @author yeyulin
 * @description: 10 单链表排序
 * @date 2020/7/31 8:31
 **/
public class LinkedSort {
    public Node quickSort(Node head) {
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

    public Node quickSort2(Node head) {
        Node cur = head;
        while (cur != null) {
            int curVal = cur.val;
            Node next = cur.next;
            while (next != null) {
                int val = next.val;
                if (curVal > val) {
                    int temp = curVal;
                    curVal = val;
                    val = temp;
                    cur.val = curVal;
                    next.val = val;
                }
                next = next.next;
            }
            cur = cur.next;

        }
        return head;
    }
    public Node linkSort3(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node cur=head;
        while(cur.next!=null){
            int curValue=cur.val;
            Node nextNode=cur.next;
            while(nextNode!=null){
                int nextVal=nextNode.val;
                if(curValue>nextVal){
                    int temp=curValue;
                    curValue=nextVal;
                    nextVal=temp;
                    cur.val=curValue;
                    nextNode.val=nextVal;
                }
                nextNode=nextNode.next;
            }
            cur=cur.next;
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
        LinkedSort linkedSort = new LinkedSort();
        Node node = linkedSort.linkSort3(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
