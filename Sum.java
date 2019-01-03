package ss.week4.math;
import ss.week4.math.Function;

public class Sum implements Function, Integrandable
{
	Function func1;
	Function func2;
	//_______________constructor______________
	public Sum(Function f1, Function f2)
	{
		this.func1=f1;
		this.func2=f2;
	}
	//_______________commands__________________
	public double apply (double argument)
	//parameter: double argument or int argument?
	{
		return func1.apply(argument)+func2.apply(argument);
	}
	
	public Function derivative ()
	{
		Sum sum=new Sum(func1.derivative(),func2.derivative());
		return sum; 
	}
	
	public String toString ()
	{
		return "("+func1+")+("+func2+")";
	}
	
	@Override
	public Function integrand() 
	{
		if (((Integrandable)func1).integrand()!=null&&((Integrandable)func2).integrand()!=null)
		{
			return new Sum(((Integrandable)func1).integrand(), ((Integrandable)func2).integrand());
		}
		return null;
	}
}
