package com.datasouce.timbersaw.queue;

import java.util.Stack;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/29 17:14
 **/
public class Queue2 {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(Integer value) {
        pushStack.push(value);
    }

    public Integer pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        Integer pop1 = q.pop();
        System.out.println(pop1);
        q.push(6);
        Integer pop2 = q.pop();
        System.out.println(pop2);
        Integer pop3 = q.pop();
        System.out.println(pop3);
        Integer pop4 = q.pop();
        System.out.println(pop4);
        Integer pop5 = q.pop();
        System.out.println(pop5);
        Integer pop6 = q.pop();
        System.out.println(pop6);
    }
}
