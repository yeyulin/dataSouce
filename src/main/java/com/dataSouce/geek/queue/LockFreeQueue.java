package com.dataSouce.geek.queue;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.IntStream;

public class LockFreeQueue {
    private AtomicReferenceArray atomicReferenceArray;
    private static final Integer EMPTY=null;
    private int size;
    AtomicInteger head,tail;
    public LockFreeQueue(int size){
        this.atomicReferenceArray=new AtomicReferenceArray(size);
        this.size=size;
        this.head=new AtomicInteger(0);
        this.tail=new AtomicInteger(0);
    }
    public boolean enqueue(Integer element){
        int index = (tail.get() + 1) % size;
        if(index==head.get()%size){
            System.out.println("当前队列已满,"+ element+"无法入队!");
            return false;
        }
        while (!atomicReferenceArray.compareAndSet(index,EMPTY,element)){
            return enqueue(element);
        }
        tail.incrementAndGet();
        System.out.println("入队成功!" + element);
        return true;
    }
    public Integer dequeue(){
        if(head.get()==tail.get()){
            System.out.println("当前队列为空");
            return null;
        }
        int index=(head.get()+1)%size;
        Integer element = (Integer)atomicReferenceArray.get(index);
        if(Objects.isNull(element)){
            return dequeue();
        }
        while(!atomicReferenceArray.compareAndSet(index,element,EMPTY)){
            return dequeue();
        }
        head.incrementAndGet();
        System.out.println("出队成功!" + element);
        return element;
    }
    public void print(){
        StringBuffer buffer = new StringBuffer("[");
        for(int i = 0; i < atomicReferenceArray.length() ; i++){
            if(i == head.get() || atomicReferenceArray.get(i) == null){
                continue;
            }
            buffer.append(atomicReferenceArray.get(i) + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");
        System.out.println("队列内容:"    +buffer.toString());

    }

    public static void main(String[] args) {
        LockFreeQueue queue = new LockFreeQueue(5);
        IntStream.rangeClosed(1, 10).parallel().forEach(
                i -> {
                    if (i % 2 == 0) {
                        queue.enqueue(i);
                    } else {
                        queue.dequeue();
                    }
                }
        );
        queue.print();
    }
}
