package ru.vilensky.sort;
//TODO: test class, remove
public class Main {
    public static void main(String[] args) {
        Integer[] a = {12, 3, 5 ,50, 21, 24, 11, 5, 17, 8, 1, 1};
        String[] s = {"AAA", "hgyt", "dggf", "aa", "uty", "nn", "mnm"};
        Sort srt = new Sort();
        srt.bubble(a);
        srt.quick(s);
        for(Integer i: a){
            System.out.print(i+" ");
        }
        for(String i: s){
            System.out.print(i+" ");
        }
    }
}
