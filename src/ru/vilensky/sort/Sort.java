package ru.vilensky.sort;
//TODO: merge, insert, maybe bucket
public class Sort {
    public <E extends Comparable<E>> void merge(E[] array){
        int len = array.length;
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
