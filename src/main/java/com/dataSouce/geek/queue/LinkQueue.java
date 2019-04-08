package com.dataSouce.geek.queue;

import com.dataSouce.geek.link.Node;

import java.util.Objects;

public class LinkQueue {
    private int count;
    private Node root;

    public LinkQueue(int count) {
        this.count = count;
    }
    public boolean enqueque(int value){
        if(Objects.isNull(root)){
            root=Node.createNode(value);
        }
        Node temp= root;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=Node.createNode(value);
        return true;
    }
    public Integer dequeque(){
        if(Objects.isNull(root)){
            return null;
        }
        root=root.next;
        return root.data;
    }

    public static void main(String[] args) {
        int size=5;
        LinkQueue linkQueue=new LinkQueue(size);
        for (int i = size; i >0; i--) {
            linkQueue.enqueque(i);
        }
        for (int i = 0; i < size; i++) {
            System.out.print(linkQueue.dequeque()+",");
        }
        System.out.println();
    }
}
