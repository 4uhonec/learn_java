package ru.vilensky.sort;
//TODO:  insert, maybe bucket
public class Sort {
    public <E extends Comparable<E>> void merge(E[] array){
		merge(array, 0, array.length - 1);
    }

	private <E extends Comparable<E>> void merge(E[] array, int left, int right){
		if(left < right){
			int mid = (left + right)/2;
			merge(array, left, mid);
			merge(array, mid + 1, right);
			mergeSort(array, left, mid, right);
		}
	}

	private <E extends Comparable<E>> void mergeSort(E[] array, int left, int mid, int right){
		int lenLeft = mid - left + 1;
		int lenRight = right - mid;
		
		//temp arrays
		E[] leftArr = (E[])new Object[lenLeft];
		E[] rightArr = (E[])new Object[lenRight];
		
		//fill temp arrays
		for(int i = 0; i<lenLeft; i++){
			leftArr[i] = array[left + i];
		}
		
		for(int i = 0; i<lenRight; i++){
			rightArr[i] = array[mid + i + 1];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < lenLeft && j < lenRight){    
        	if(leftArr[i].compareTo(rightArr[j])<=0){    
            	array[k] = leftArr[i];    
            	i++;    
        	}    
        	else{    
            	array[k] = rightArr[j];    
            	j++;    
        	}    
			k++;    
		}    
		while (i<lenLeft){    
        	array[k] = leftArr[i];    
			i++;    
			k++;    
		}    
      
		while (j<lenRight){    
			array[k] = rightArr[j];    
			j++;    
			k++;    
		}
	}

    public <E extends Comparable<E>> void quick(E[] array){
		quick(array, 0, array.length - 1);
    }

	private <E extends Comparable<E>> void quick(E[] array, int left, int right){
		if(left < right){
			int pivotIndex = partition(array, left, right);
			quick(array, left, pivotIndex - 1);
			quick(array, pivotIndex + 1, right);
		}
	}

	//choosing rightmost element as pivot
	private <E extends Comparable<E>> int partition(E[] array, int left, int right){
		E pivot = array[right];
		int pivotWall = left- 1;
		for(int j = left; j < right; j++){
			if(array[j].compareTo(pivot) <= 0){
				pivotWall++;
				swap(array, pivotWall, j);
			}
		}
		swap(array, pivotWall + 1, right);

		return pivotWall + 1;
	}

    public <E extends Comparable<E>> void bubble(E[] array){
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(array[j].compareTo(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public <E extends Comparable<E>> void insertion(E[] array){
        int len = array.length;
    }

    private <E extends Comparable<E>> void swap(E[] array, int i, int j){
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
