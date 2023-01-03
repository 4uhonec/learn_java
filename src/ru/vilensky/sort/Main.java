package ru.vilensky.sort;
//TODO: test class, remove
public class Main {
    public static void main(String[] args) {
        Integer[] A = {12, 3, 5 ,50, 21, 24, 11, 5, 17, 8, 1, 1};
        String[] s = {"AAA", "hgyt", "dggf", "aa", "uty", "nn", "mnm"};
        Sort<String> stringSort = new Sort<>();
        Sort<Integer> sort = new Sort<>();
        Integer[] B = sort.bubble(A);
        String[] S = stringSort.bubble(s);
        for(Integer i: B){
            System.out.print(i+" ");
        }
        for(String i: S){
            System.out.print(i+" ");
        }
    }
}
