package ru.vilensky.heap;

public class Heap {

    private int size;
    private int[] arr;

    public Heap(int[] arr)
    {
        this.arr = arr;
        this.size = this.arr.length - 1;
    }

    private void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //if new element inserted into heap in place i, makes order in this heap part
    private void heapify(int i)
    {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;

        if(left <= size && arr[left] > arr[max]) max = left;
        if(right <= size && arr[right] > arr[max]) max = right;
        if(max != i )
        {
            swap(i,max);
            heapify(max);
        }
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        int temp = 1;
        for(int i = 0; i <= size; i++)
        {
            str.append(arr[i]).append(" ");
            if(i+2 == Math.pow(2, temp))
            {
                str.append("\n");
                temp++;
            }
        }

        return str.toString();
    }

    public int heapMax()
    {
        return arr[0];
    }

    public int extractMax ()//READY
    {
        int max;
        if(size < 1)
        {
            System.out.println("heap underflow");
            return -1;
        }
        max = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return max;
    }

    public void insertHeap(int num, int i)
    {
        if(i> size)
        {
            System.out.println("Out of heap size");
            return;
        }
        arr[i] = num;
        while(i>0 && arr[i] > arr[i/2])
        {
            swap(i, i/2);
            i = i/2;
        }
        heapify(i);
    }

    public void heapSort()
    {
        int tempSize = size;
        for(int j = size; j >= 1; j--){
            swap(0,j);
            size--;
            heapify(0);
        }
        size = tempSize;
    }

    public void buildHeap()
    {
        for(int i = size /2; i>=0; i--){
            heapify(i);
        }
    }

    public void insertLeaf(int leaf)
    {

    }
}