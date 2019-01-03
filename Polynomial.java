//P4.9
package ss.week4.math;

public class Polynomial implements Function, Integrandable
{
	double[] array;
	
	//_______________constructor______________
	/**Develop a class Polynomial, 
	 * implementing the interface Function, 
	 * to represent arbitrary polynomial functions. 
	 * The parts should be given to the constructor as an array from doubles.
	 * Hint: initialise an array of LinearProducts (Constant, Exponent) in the constructor. 
	 * Note that to calculate the derivative, 
	 * you only have to return the sum of the derivative of all elements in the array.
	 */
	//_______________________constructor_____________________
	public Polynomial (double[] doubleArray)
	{
		array = new double[doubleArray.length];
		System.arraycopy( doubleArray, 0, array, 0, doubleArray.length );

	}
	//________________commands_________________

	public double apply (double x)
	{
		Sum sum= new Sum(new Constant(0),new Constant(0));
		for (int i=0;i<array.length;i=i+1)
		{
			Constant c=new Constant(array[i]);
			Exponent exp=(new Exponent(i));
			LinearProduct linProd=new LinearProduct (c,exp);
			sum=new Sum (linProd,sum);
		}
		return sum.apply(x); //(an)*(x^n)
	}
	
	/**to calculate derivative, return the sum of derivative of all elements in the array*/
	public Function derivative()
	{
		Sum sum= new Sum(new Constant(0),new Constant(0));
		for (int i=0;i<array.length;i=i+1)
		{
			Constant c=new Constant(array[i]);
			Exponent exp=(new Exponent(i));
			LinearProduct linProd=new LinearProduct (c,exp.derivative());
			sum=new Sum (linProd,sum);
		}
		return sum;
	}


	@Override
	public Function integrand() 
	{
		Sum sum= new Sum(new Constant(0),new Constant(0));
		for (int i=0;i<array.length;i=i+1)
		{
			Constant c=new Constant(array[i]);
			Exponent exp=(new Exponent(i));
			LinearProduct linProd=new LinearProduct (c,exp.integrand());
			sum=new Sum (linProd,sum);
		}
		return sum;
	}

	
	public String toString ()
	{
		String s=" ";
		String element;
		for (int i=0;i<array.length;i=i+1)
		{
			Constant c=new Constant(array[i]);
			Exponent exp=(new Exponent(i));
			element="("+c+")*("+exp+")";
			s=s+element;
		}
		return s;
	}
}
