package ru.vilensky.generative_art;
import processing.core.PApplet;
import processing.core.PShape;

//before launching applet, you have to do some preparation.
//add every .jar file in libs folder to libraries:
//RMC on jar -> Add as library

//This is just the basic setup, check https://processing.org for more info

public class GenArtBasic extends PApplet implements Consts{
    
    public void settings(){
        size(WIDTH, HEIGHT);
    }

    public void draw(){
        background(255);

        
        /*strokeWeight(1);
        int n = 1;

        for(int i = 1; i<width; i+=n){
            stroke(0);
            line(0, i, width, i);
            n++;
        }*/

        //since draw() redrawing window infinitely, noLoop() changes this behavior
        noLoop();
    }

    //TODO: move constants to Const.java
    public static PShape[] getRectArray(){
        int numOfRects = 10;
        int rectSize =70;
        int gapSize = 20;
        int x1 = WIDTH - (rectSize*numOfRects + gapSize*(numOfRects - 1))
        PShape[] rectArray = new PShape[10];


        return rectArray;
    }

    public static void main(String[] args) {
        PApplet.main("ru.vilensky.generative_art.GenArtBasic");
    }
}
