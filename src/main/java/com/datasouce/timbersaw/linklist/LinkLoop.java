package com.datasouce.timbersaw.linklist;

/**
 * @author yeyulin
 * @description: 15
 * @date 2020/7/31 18:42
 **/
public class LinkLoop {
    public Boolean judge(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);


        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l3);
        LinkLoop linkLoop = new LinkLoop();
        Boolean judge = linkLoop.judge(l1);
        System.out.println(judge);
    }
}
