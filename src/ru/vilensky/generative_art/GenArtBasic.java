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
        stroke(120);
        float[] quads = getRectArray();
        for(int i = 0; i<quads.length - 1; i+=8){
            quad(quads[i], quads[i+1],
                 quads[i+2], quads[i+3],
                 quads[i+4], quads[i+5],
                 quads[i+6], quads[i+7]);
        }

        //since draw() redrawing window infinitely, noLoop() changes this behavior
        noLoop();
    }

    //TODO: move constants to Const.java
    public static float[] getRectArray(){
        SecureRandom random = new SecureRandom();
        float x1 = (WIDTH - (RECT_SIZE*NUM_OF_RECTS + GAP_SIZE*(NUM_OF_RECTS - 1)))/2;
        float y1 = x1;
        float[] rectArray = new float[NUM_OF_RECTS*NUM_OF_RECTS*8];
        int counter = 0;
        
        for(int i = 0; i < NUM_OF_RECTS; i++){
            for (int j = 0; j < NUM_OF_RECTS; j++) {
                rectArray[counter] = x1 + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+1] = y1 + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+2] = x1 + RECT_SIZE + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+3] = y1 + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+4] = x1 + RECT_SIZE + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+5] = y1 + RECT_SIZE + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+6] = x1 + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                rectArray[counter+7] = y1 + RECT_SIZE + (random.nextFloat(2) - 1)*(i+j)*LAMBDA;
                counter+=8;
                System.out.print(x1+" "+y1+"--");
                x1 += RECT_SIZE + GAP_SIZE;
            }
            x1 = (WIDTH - (RECT_SIZE*NUM_OF_RECTS + GAP_SIZE*(NUM_OF_RECTS - 1)))/2;
            y1+=RECT_SIZE+GAP_SIZE;
        }

        return rectArray;
    }

    //public static PShape makeShape(color c, )

    public static void main(String[] args) {
        PApplet.main("ru.vilensky.generative_art.GenArtBasic");
    }
}
