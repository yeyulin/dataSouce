package com.dataSouce.heap;

import java.util.ArrayList;
import java.util.Arrays;

import com.dataSouce.test.SortTestHelper;

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
	 private void ensureCapacityInternal(int minCapacity) {
		  if (minCapacity - data.length >= 0)
	            grow(minCapacity);
	    }
	 private void grow(int minCapacity) {
	        // overflow-conscious code
	        int oldCapacity = data.length;
	        // oldCapacity >> 1 相当于 oldCapacity/2
	        int newCapacity = oldCapacity + (oldCapacity >> 1);
	        if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
	        // minCapacity is usually close to size, so this is a win:
	        data = Arrays.copyOf(data, newCapacity);
	    }
	/***
	 * @param i 添加元素的下标
	 * @return 将i 放入到应该的位置 维持最大堆
	 * */
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
	public static void main(String[] args) {
		 MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
