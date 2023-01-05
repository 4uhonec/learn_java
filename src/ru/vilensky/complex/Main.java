package ru.vilensky.complex;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Complex z = new Complex(-1, 0);
        ArrayList<Complex> l = z.root(30);
        for(Complex c : l){
            System.out.println(c);
        }

        //System.out.println();
    }
}
