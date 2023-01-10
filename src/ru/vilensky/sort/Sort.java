package ru.vilensky.sort;
//TODO: merge, quick, insert, heap, maybe bucket
public class Sort <E extends Comparable<E>>{
    public E[] merge(E[] array){
        int len = array.length;
        return null;
    }

    public E[] quick(E[] array){
        int len = array.length;
        return null;
    }

    public E[] bubble(E[] array){
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(array[j].compareTo(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public E[] insertion(E[] array){
        int len = array.length;
        return null;
    }

    private void swap(E[] array, int i, int j){
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
