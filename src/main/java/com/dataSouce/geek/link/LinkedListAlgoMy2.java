package com.dataSouce.geek.link;

public class LinkedListAlgoMy2 {
    public static Node reversal(Node list){
        Node previousNode=null;
        while(list!=null){
            Node nextNode = list.next;
            list.next=previousNode;
            previousNode=list;
            list=nextNode;
        }
        return previousNode;
    }
    public static boolean checkCircle(Node list){
        if(list==null || list.next==null){
            return false;
        }
        Node fast=list;
        Node slow=list;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                return true;
            }

        }
        return false;
    }
    public static Node mergeLink(Node param,Node param2){
        Node node=null;
        if(param==null){
            node=param2;
        }
        if(param2==null){
            node=param;
        }
        if(param.data>param2.data){
            node=new Node(param2.data,null);
            param2=param2.next;
        }else{
            node=new Node(param.data,null);
            param=param.next;
        }
        Node head=node;
        while (param!=null && param2!=null){
            if(param.data>param2.data){
                head.next=param2;
                param2=param2.next;
            }else{
                head.next=param;
                param=param.next;
            }
            head= head.next;
        }
        if(param!=null ){
            head.next=param;
        }
        if(param2!=null ){
            head.next=param2;
        }
        return node;
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
        //node5.next=node6;
        Node.printAll(node);
        node3.next=node4;
        Node.printAll(node3);
        Node node1 = LinkedListAlgoMy2.mergeLink(node, node3);
        Node.printAll(node1);
        //  System.out.println(LinkedListAlgoMy2.checkCircle(node));
//        LinkedListAlgoMy2.printAll(node);
//        node6.next=node3;
//        node3.next=node4;
//        LinkedListAlgoMy2.printAll(node6);
//        Node node1 = LinkedListAlgoMy2.mergeSortedLists(node, node6);
//        LinkedListAlgoMy2.printAll(node1);

    }

}
