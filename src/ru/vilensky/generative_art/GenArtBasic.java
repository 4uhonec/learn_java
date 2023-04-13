package ru.vilensky.generative_art;
import java.security.SecureRandom;

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

        //since draw() redrawing window infinitely, noLoop() changes this behavior
        noLoop();
    }

    //TODO: move constants to Const.java
    public static PShape[] getRectArray(){
        SecureRandom random = new SecureRandom();
        int x1 = WIDTH - (RECT_SIZE*NUM_OF_RECTS + GAP_SIZE*(NUM_OF_RECTS - 1));
        int y1 = x1;
        PShape[] rectArray = new PShape[NUM_OF_RECTS*NUM_OF_RECTS];
        int counter = 0;
        
        for(int i = 0; i < NUM_OF_RECTS; i++){
            for (int j = 0; j < NUM_OF_RECTS; j++) {
                PShape pShape = 
            }
        }

        return rectArray;
    }

    public static PShape makeShape(color c, )

    public static void main(String[] args) {
        PApplet.main("ru.vilensky.generative_art.GenArtBasic");
    }
}
