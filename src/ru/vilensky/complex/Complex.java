package ru.vilensky.complex;

import java.util.ArrayList;

public class Complex{
	private double re, im;

	public Complex(double re, double im){
		this.re = re;
		this.im = im;
	}

	public double re(){
		return re;
	}

	public double im(){
		return im;
	}

	//returns angle in radians
	public double arg(){
		return Math.atan2(im, re);
	}

	public Complex getFromPolar(double mod, double arg){
		return new Complex(round(mod*Math.cos(arg)),
						   round(mod*Math.sin(arg)));
	}

	public Complex add(Complex other){
		return new Complex(re + other.re(), im + other.im());
	}

	public Complex substract(Complex other){
		return new Complex(re - other.re(), im - other.im());
	}

	public Complex multiply(Complex other){
		double re2 = other.re();
		double im2 = other.im();

		return new Complex(re*re2 - im*im2,
						   re*im2 + im*re2);
	}

	public Complex divide(Complex other){
		double re2 = other.re();
		double im2 = other.im();
		double div = re2*re2 + im2*im2;

		return new Complex((re*re2 + im*im2)/div,
							(im*re2 - re*im2)/div);
	}
/*
	//only for integer n
	public Complex pow(int n){
		
	}
*/
	//
	public ArrayList<Complex> root(int n){
		ArrayList<Complex> roots = new ArrayList<>();
		double theta = this.arg();
		double mod = Math.pow(this.mod(), 1.0/(double)n);
		for(int k = 0; k<n; k++){
			double arg = ((theta + 2.0*Math.PI*(double)k)/(double)n);
			//arg = round(arg);
			roots.add(getFromPolar(mod, arg));
		}
		return roots;
	}

	public double mod(){
		return Math.sqrt(re*re + im*im);
	}

	public Complex conjugate(){
		return new Complex(re, -im);
	}
	
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer();
		if(re != 0)
			str.append(this.re);
		if(im>0){
			str.append("+").append(im).append("i");
		}else if(im<0)
			str.append(im).append("i");
		return str.toString();
	}

	//have to round Im and Re values due to non-ideal approximation
	private double round(double num){
		num = Math.round(num * 10000000.0) / 10000000.0;
		return num;
	}

}
