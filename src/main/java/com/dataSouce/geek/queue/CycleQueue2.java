package com.dataSouce.geek.queue;

import java.util.Arrays;

/**
 * https://blog.csdn.net/fansongy/article/details/6784954
 */
public class CycleQueue2 {
    private int[]items;
    private int size;
    private int head;
    private int tail;

    public CycleQueue2(int size) {
        items=new int[size];
        this.size = size;
    }
    public boolean enqueue(int item){
        //当整个对列都为空时 head==0，tail + 1==size
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail]=item;
        tail=(tail + 1) % size;
        return true;
    }
    public Integer dequeue(){
        if (head == tail) {
            return null;
        }
        int item = items[head];
        if(head+1==size){
            head=(head+1)%size;
            return item;
        }
        head++;
        return item;
    }

    public static void main(String[] args) {
        int size=5;
        CycleQueue2 arrayQueue=new CycleQueue2(size);
        for (int i = size; i >0; i--) {
            arrayQueue.enqueue(i);
        }
        System.out.println(Arrays.toString(arrayQueue.items));
        for (int i = 0; i < size; i++) {
            System.out.println(arrayQueue.dequeue());
        }
        System.out.println(Arrays.toString(arrayQueue.items));

    }


}
