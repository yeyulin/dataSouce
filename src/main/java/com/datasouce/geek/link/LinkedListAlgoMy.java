package com.datasouce.geek.link;

public class LinkedListAlgoMy {
    public static Node reverse(Node root){
        Node headNode=null;
        Node currentNode=root;
        Node previousNode=null;
        while (currentNode!=null){
            Node nextNode = currentNode.next;
            if(nextNode==null){
                headNode=currentNode;
            }
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return headNode;
    }
    public static boolean checkCircle(Node list){
        if(list==null){
            return  false;
        }
        Node fast=list.next;
        Node slow=list;
        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow= slow.next;
            if(slow.equals(fast)){
                return true;
            }
        }
        return false;
    }

    public static Node mergeSortedLists(Node la, Node lb) {

        if (la == null) return lb;
        if (lb == null) return la;
        Node rootNode;
        if (la.data < lb.data) {
            rootNode = la;
            la = la.next;
        } else {
            rootNode = lb;
            lb= lb.next;
        }
        Node head=rootNode;
        while(la!=null && lb!=null){
            if(la.data>=lb.data){
                head.next=lb;
                lb= lb.next;
            }else{

                head.next=la;
                la= la.next;
            }
            head=head.next;
        }
        if(la!=null){
            head.next=la;
        }
        if(lb!=null){
            head.next=lb;
        }
        return rootNode;
    }
    public static Node mergeSortedLink(Node la, Node lb) {
        Node head = null;
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        if(la.data>lb.data){
            head=lb;
            Node node = mergeSortedLink(la, lb.next);
            head.next= node;
        }else{
            head=la;
            Node node = mergeSortedLink(la.next, lb);
            head.next= node;
        }
        return head;
    }
    public static Node mergeSortedLists2(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    public static Node deleteLastKth2(Node head,int k){
        if(head==null || k<=0){
            return head;
        }
        Node previousNode=head;
        Node currentNode=head;

        for(int i=1;i<=k && previousNode!=null;i++){
            previousNode=previousNode.next;
        }
        if(previousNode==null){
            return head.next;
        }
        while(previousNode.next!=null){
            previousNode=previousNode.next;
            currentNode=currentNode.next;
        }
        currentNode.next=currentNode.next.next;
        return head;
    }
    public static Node deleteLastKth3(Node head,int k){
        if(head==null || k<=0){
            return head;
        }
        Node previousNode=head;
        Node currentNode=head;

        for(int i=1;i<=k && previousNode!=null;i++){
            previousNode=previousNode.next;
        }
        if(previousNode==null){
            return head.next;
        }
        while(previousNode.next!=null){
            previousNode=previousNode.next;
            currentNode=currentNode.next;
        }
        currentNode.next=currentNode.next.next;
        return head;
    }
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }
    public static Node findMiddleNode(Node list){
        Node fastNode=list;
        Node slowNode=list;
        while(fastNode.next!=null && fastNode.next.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        return slowNode;
    }
    public static void main(String[] args) {
        Node node = Node.createNode(1);
        Node node2 = Node.createNode(2);
        Node node3 = Node.createNode(3);
        Node node4 = Node.createNode(4);
        Node node5 = Node.createNode(5);
        Node node6 = Node.createNode(0);
        node.next=node2;
        node2.next=node5;
        node5.next=node3;
        node3.next=node4;
        Node.printAll( node);
       Node.printAll( LinkedListAlgoMy.findMiddleNode(node));
//        Node.printAll(node);
//        node6.next=node3;
//        node3.next=node4;
//        Node.printAll(node6);
//        Node node1 = LinkedListAlgoMy.mergeSortedLists(node, node6);
//        Node.printAll(node1);
//        LinkedListAlgoMy.printAll(node);
//        Node reverse = LinkedListAlgoMy.reverseNode(node);
//        LinkedListAlgoMy.printAll(reverse);
    }
    public static Node reverseNode(Node list){
        Node rootNode=null;
        Node currentNode=list;
        Node previousNode=null;
        while(currentNode!=null){
            Node nextNode = currentNode.next;
            if(nextNode==null){
                rootNode= currentNode;
            }
            currentNode.next=previousNode;

            previousNode=currentNode;
            currentNode=nextNode;
        }
        return rootNode;
    }
}
