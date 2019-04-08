package com.dataSouce.geek.queue;

import java.util.Arrays;

public class ArrayQueue {
    private int []data;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue( int size) {
        this.data = new int[size];
        this.size = size;
    }
    public boolean enqueue(int value){
        if(tail==size){
            if(head==0){
                return false;
            }
            for(int i=head;i<tail;i++){
                data[i-head]=data[i];
            }
            tail=tail-head;
            head=0;
        }

        data[tail]=value;
        tail++;
        return true;
    }
    public Integer dequeque(){
        if(head==tail){
            return null;
        }
        int datum = data[head];
        data[head]=-1;
        head++;
        return datum;
    }

    public static void main(String[] args) {
        int size=5;
        ArrayQueue arrayQueue=new ArrayQueue(size);
        for (int i = 0; i < size; i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(arrayQueue.dequeque());
        }
        System.out.println(Arrays.toString(arrayQueue.data));
        for (int i = 0; i < size; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(Arrays.toString(arrayQueue.data));
    }
}
