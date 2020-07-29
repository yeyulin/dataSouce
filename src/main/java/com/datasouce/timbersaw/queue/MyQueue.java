package com.datasouce.timbersaw.queue;

import java.util.Stack;

/**
 * @author yeyulin
 * @description: 7.两个栈实现一个队列
 * @date 2020/7/29 9:10
 **/
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException();
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
