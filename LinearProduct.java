package ss.week4.math;

public class LinearProduct extends Product implements Integrandable
{
	//_______________constructor______________
	public LinearProduct (Constant constant,Function function)
	{
		super(constant,function );
	}
	
	//_________________commands__________________

	public Function derivative()
	{
		return new LinearProduct((Constant)func1,func2.derivative());
	}
	
	public String toString()
	{
		return "("+func1+"*"+func2+")";
	}
	
	@Override
	public Function integrand() 
	{
		if (((Integrandable)func2).integrand()!=null)
		{
			return new LinearProduct((Constant)func1,((Integrandable)func2).integrand());
		}
		return null;
	}
	
}
