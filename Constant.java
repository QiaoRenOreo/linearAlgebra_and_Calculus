package ss.week4.math;
import ss.week4.math.Product;
public class Constant implements Function, Integrandable
{
	private double constant; 
	//_______________constructor______________
	public Constant (double aConstant)
	{
		this.constant=aConstant;
	}
	//__________________commands_______________
	public double apply (double argument)
	{
		return this.constant;
	}
	public Function derivative()
	{
		Constant i=new Constant(0);//create a new Constant
		return i;
	}

	@Override
	public Function integrand() 
	{
		Product p= new LinearProduct(new Constant(constant), new Exponent(1));
		// c*x
		return p;
	}
	
	public String toString ()
	{
		return "("+Double.toString(this.constant)+")";
	}
}
