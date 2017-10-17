package com.dataSouce.heap;

import java.util.Arrays;


public class MaxHeap<T extends Comparable> {
	protected int count;
	protected T[] data;
	 // 构造函数, 构造一个空堆, 可容纳capacity个元素
	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		data = (T[])new Comparable[capacity+1];
		count=0;
	}
	public int size() {
		return count;
	}
	public boolean isEmpty(){
        return count == 0;
    }
	public void insert(T temp) {
	    ensureCapacityInternal(count + 1);  // Increments modCount!!
		data[count+1]=temp;
		count++;
		shiftUp(count);
	}
	public T pop() {
		assert (count>0);
		T t=data[1];
		swapHeap(1, count);
		count--;
		shiftDown(1);
		return t;
	}
	
	private void shiftDown(int k) {
		//是否具有右节点
		while(2*k<=count) {
			int i=2*k;
			//存在左节点 且左节点大于右节点
			if(i+1<=count && data[i+1].compareTo(data[i])>0) {
				i+=1;
			}
			if(data[k].compareTo(data[i])>0) {
				break;
			}
			swapHeap(k, i);
		}
	}
	/***
	 * @param i 添加元素的下标
	 * @return 将i 放入到应该的位置 维持最大堆
	 * */
	@SuppressWarnings("unchecked")
	public void shiftUp(int i) {
		while(i>1 && data[i].compareTo(data[i/2])>0) {
			swapHeap(i, i/2);
			i/=2;
		}
	}
	 // 交换堆中索引为i和j的两个元素
    private void swapHeap(int i, int j){
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    private void ensureCapacityInternal(int minCapacity) {
		  if (minCapacity - data.length >= 0)
	            grow(minCapacity);
	    }
	 private void grow(int minCapacity) {
	        int oldCapacity = data.length;
	        // oldCapacity >> 1 相当于 oldCapacity/2
	        int newCapacity = oldCapacity + (oldCapacity >> 1);
	        if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
	        data = Arrays.copyOf(data, newCapacity);
	   }
	public static void main(String[] args) {
		 MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
