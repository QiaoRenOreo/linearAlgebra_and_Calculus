package ss.week4.test;

import ss.week4.math.Function;
import ss.week4.math.Integrandable;
import ss.week4.math.Constant;
import ss.week4.math.Polynomial;
import ss.week4.math.Sum;
import ss.week4.math.Product;
import ss.week4.math.LinearProduct;
import ss.week4.math.Exponent;
/**
 * P-4.14 Make a class Homework with the following functionality: 
 * Make a main method where you print and test several combinations of the created functions. 
 * You should print the functions and their outcome.
e.g.:
	LinearProduct f1 = new LinearProduct (new Constant (4),new Exponent (4));
	Function f2 = f1.integrand ();
	Function f3 = f1.derivative ();
	System.out.println("f(x) = " + f1 + ", f(8) = " + f1.apply (8));
	System.out.println("f(x) = " + f2 + ", f(8) = " + f2.apply (8));
	System.out.println("f(x) = " + f3 + ", f(8) = " + f3.apply (8));
Which has the following outcome:
	f(x) = (4.0) * (xˆ4), f(5) = 16384.0
	f(x) = (4.0) * ((0.2) * (xˆ5)), f(5) = 26214.4
	f(x) = (4.0) * ((4.0) * (xˆ3)), f(5) = 8192.0
*/
public class Homework 
{
	public static void main(String [ ] args)
	{
		LinearProduct f1 = new LinearProduct (new Constant (4),new Exponent (4));
		Function f2 = f1.integrand ();
		Function f3 = f1.derivative ();
		System.out.println("f1(x) = " + f1 + ", f(8) = " + f1.apply (8));
		System.out.println("f2(x) = " + f2 + ", f(8) = " + f2.apply (8));// why 0.0?
		System.out.println("f3(x) = " + f3 + ", f(8) = " + f3.apply (8));
		
		Sum f4=new Sum (new Constant(2),new Exponent (4));
		Function f5=f4.integrand();
		Function f6=f4.derivative();
		System.out.println("f4(x) = " + f4 + ", f(8) = " + f4.apply (8));
		System.out.println("f5(x) = " + f5 + ", f(8) = " + f5.apply (8));
		System.out.println("f6(x) = " + f6 + ", f(8) = " + f6.apply (8));
	}
}
