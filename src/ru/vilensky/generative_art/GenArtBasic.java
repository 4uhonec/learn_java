package ru.vilensky.generative_art;
import processing.core.PApplet;

//before launching applet, you have to do some preparation.
//add every .jar file in libs folder to libraries:
//RMC on jar -> Add as library

//This is just the basic setup, check https://processing.org for more info

public class GenArtBasic extends PApplet{

    public void settings(){
        size(500, 500);
    }

    public void draw(){
        background(255);
        strokeWeight(1);
        int n = 1;

        for(int i = 1; i<width; i+=n){
            stroke(0);
            line(0, i, width, i);
            n++;
        }

        //since draw() redrawing window infinitely, noLoop() changes this behavior
        noLoop();
    }

    public static void main(String[] args) {
        PApplet.main("ru.vilensky.generative_art.GenArtBasic");
    }
}
