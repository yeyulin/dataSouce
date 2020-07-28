package com.datasouce.heap;

public class IndexMaxHeap<T extends Comparable> {
	protected int count;
	//最大索引堆索引
	public static int []indexes;
	//最大索引堆中的数据
	protected  T [] data;
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
	    shiftUp(count);
	}
	// 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public T extractMax(){
    	  assert count > 0;
    	T t=data[indexes[1]];
    	sweapIndex( 1 , count );
    	count--;
    	shiftDown(1);
    	return t;
    }
   public T[]  getData(){
	   return data;
   }
    public void change(int index,T t) {
    	index++;
    	data[index]=t;
    	// 找到indexes[i] = index, i表示data[index]在堆中的位置
        // 之后shiftUp(i), 再shiftDown(i)
    	for(int i=1;i<=count;i++) {
    		if(indexes[i]==index) {
    			shiftDown(i);
    			shiftUp(i);
    		}
    	}
    }
	private void shiftDown(int k) {
		while(2*k<= count) {
			int j=2*k;
			if(j+1<=count && data[indexes[j+1]].compareTo(data[indexes[j]])>0) {
				j++;
			}
			if(data[indexes[k]].compareTo(data[indexes[j]])>=0) {
				break;
			}
			sweapIndex(k, j);
			k=j;
		}
	}
	public void sweapIndex(int i,int j) {
		int t=indexes[i];
		indexes[i]=indexes[j];
		indexes[j]=t;
		
	}
	 // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
	private void shiftUp(int k) {
		while(k>1 && data[indexes[k/2]].compareTo(data[indexes[k]])<0) {
			sweapIndex(k, k/2);
			k/=2;
		}
	}
	public static void main(String[] args) {
		  int N = 5;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        indexMaxHeap.insert(0, 251);
        indexMaxHeap.insert(1, 953);
        indexMaxHeap.insert(2, 264);
        indexMaxHeap.insert(3, 935);
        indexMaxHeap.insert(4, 191);
        /*for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*1000) );*/
        Comparable[] data2 = indexMaxHeap.getData();
        System.out.println(data2[indexes[2]]);
        indexMaxHeap.change(2, 10000);
        for(int i=N;i>=1;i--) {
        	System.out.print(indexMaxHeap.extractMax()+",");
        }
	}
}
