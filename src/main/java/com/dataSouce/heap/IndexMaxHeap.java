package com.dataSouce.heap;

public class IndexMaxHeap<T extends Comparable> {
	protected int count;
	//最大索引堆索引
	private int []indexes;
	//最大索引堆中的数据
	protected T [] data;
	private int capacity;
	public IndexMaxHeap(int capacity) {
		data=(T[]) new Comparable[capacity+1];
		indexes=new int[capacity+1];
		count=0;
		this.capacity=capacity;
	}
	public int size() {
		return count;
	}
	public void insert(int i,T t) {
		assert count + 1 <= capacity;
	    assert i + 1 >= 1 && i + 1 <= capacity;
	    i++;
	    data[i]=t;
	    indexes[count+1]=i;
	    count++;
	    shilfUp(count);
	}
	public void sweapIndex(int i,int j) {
		int t=indexes[i];
		indexes[i]=indexes[j];
		indexes[j]=t;
		
	}
	 // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
	private void shilfUp(int k) {
		while(k>1 && data[indexes[k/2]].compareTo(data[indexes[k]])<0) {
			sweapIndex(k, k/2);
			k/=2;
		}
	}
	public static void main(String[] args) {
		  int N = 10;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        
	}
}
