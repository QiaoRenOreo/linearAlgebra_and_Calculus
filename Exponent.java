package ss.week4.math;
import ss.week4.math.Function;

public class Exponent implements Function, Integrandable
{
	int power=0;
	//_______________constructor______________
	public Exponent(int n)
	{
		power=n;
	}
	public double apply (double x)
	{
		return Math.pow(x,power);
	}
	public Function derivative() 
	{
		return new LinearProduct(new Constant(power),new Exponent(power-1));//n*(x^(n-1))
	}
	
	public String toString ()
	{
		return ("(x^"+this.power+")");
	}
	@Override
	public Function integrand() 
	{
		Constant cons=new Constant (1/(power+1));// 1/(n+1)
		Exponent expo=new Exponent(power+1);// x^(n+1)
		return new LinearProduct(cons,expo);
	}
}
