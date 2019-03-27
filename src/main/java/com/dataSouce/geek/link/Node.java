package com.dataSouce.geek.link;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Node {

   public  Node next;
   public int data;

   public Node(int data, Node next) {
      this.data = data;
      this.next = next;
   }

   public int getData() {
      return data;
   }

   @Override
   public String toString() {
      return "Node{" +
              "next=" + next +
              ", data=" + data +
              '}';
   }
   public static Node createNode(int value) {
      return new Node(value, null);
   }
   public static void printAll(Node list) {
      Node p = list;
      while (p != null) {
         System.out.print(p.data + " ");
         p = p.next;
      }
      System.out.println();
   }
}
