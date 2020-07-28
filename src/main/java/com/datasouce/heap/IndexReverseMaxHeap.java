package com.datasouce.heap;

public class IndexReverseMaxHeap<T extends Comparable> {
	protected int count;
	//最大索引堆索引
	private int []indexes;
	//最大索引堆中的数据
	protected T [] data;
	private int []reverse;
	private int capacity;
	public IndexReverseMaxHeap(int capacity) {
		data=(T[]) new Comparable[capacity+1];
		indexes=new int[capacity+1];
		reverse=new int[capacity+1];
		for(int i=0;i<capacity+1;i++) {
			reverse[i]=-1;
		}
		count=0;
		this.capacity=capacity;
	}
	public int size() {
		return count;
	}
	public void insert(int i,T t) {
		assert count + 1 <= capacity;
	    assert i + 1 >= 1 && i + 1 <= capacity;
	 // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);
	    i+=1;
	    data[i]=t;
	    indexes[count+1]=i;
	    reverse[i]=count+1;
	    count++;
	    shiftUp(count);
	}
	
	// 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public T extractMax(){
    	  assert count > 0;
    	T t=data[indexes[1]];
    	sweapIndex( 1 , count );
    	//把indexes[count]变成-1 标识为无效
    	 reverse[indexes[count]] = -1;
    	count--;
    	shiftDown(1);
    	return t;
    }
    public void change(int index,T t) {
    	assert contain(index);
    	index++;
    	data[index]=t;
    	// 找到indexes[i] = index, i表示data[index]在堆中的位置
        // 之后shiftUp(i), 再shiftDown(i)
    	/*for(int i=0;i<count;i++) {
    		if(indexes[i]==index) {
    			shiftDown(i);
    			shiftUp(i);
    		}
    	}*/
    	shiftDown(reverse[index]);
    	shiftUp(reverse[index]);
    }
	
	public void sweapIndex(int i,int j) {
		int t=indexes[i];
		indexes[i]=indexes[j];
		indexes[j]=t;
		
		reverse[indexes[i]]=i;
		reverse[indexes[j]]=j;
		
	}
	 // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
	private void shiftUp(int k) {
		while(k>1 && data[indexes[k/2]].compareTo(data[indexes[k]])<0) {
			sweapIndex(k, k/2);
			k/=2;
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
	 // 看索引i所在的位置是否存在元素
    boolean contain( int i ){
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i+1] != -1;
    }
	public static void main(String[] args) {
		  int N = 10;
        IndexReverseMaxHeap<Integer> indexMaxHeap = new IndexReverseMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        indexMaxHeap.change(2, 100);
        for(int i=N;i>=1;i--) {
        	System.out.print(indexMaxHeap.extractMax()+",");
        }
	}
}
