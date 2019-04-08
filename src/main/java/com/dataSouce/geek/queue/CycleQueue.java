package com.dataSouce.geek.queue;

import java.util.Arrays;

public class CycleQueue {
    private int[]items;
    private int size;
    private int head;
    private int tail;

    public CycleQueue(int size) {
        items=new int[size];
        this.size = size;
    }
    public boolean enqueue(int item){
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail]=item;
        tail=(tail+1)%size;
        return true;
    }
    public Integer dequeue(){
        if (head == tail) {
            return null;
        }
        int item = items[head];
        head=(head+1)%size;
        return item;
    }

    public static void main(String[] args) {
        int size=5;
        CycleQueue arrayQueue=new CycleQueue(size);
        for (int i = 0; i < size; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(Arrays.toString(arrayQueue.items));
        for (int i = 0; i < size; i++) {
            System.out.println(arrayQueue.dequeue());
        }
        System.out.println(Arrays.toString(arrayQueue.items));
        for (int i = 0; i < size; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(Arrays.toString(arrayQueue.items));
    }
}
