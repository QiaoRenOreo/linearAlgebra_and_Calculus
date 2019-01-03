package ss.week4.math;

public class Product implements Function
{
	Function func1;
	Function func2;
	//_______________constructor______________
	public Product (Function f1, Function f2)
	{
		this.func1=f1;
		this.func2=f2;
	}
	
	//_______________commands_______________
	public double apply (double argument)
	{
		return ( func1.apply(argument)*func2.apply(argument) );
	}
	
	public Function derivative ()
	//what is the data type of the returned value?
	{
		Product p1=new Product(func1.derivative(),func2);
		Product p2=new Product(func2,func1.derivative());
		Sum sum=new Sum(p1,p2);
		return sum;
	}
	
	public String toString ()
	{
		return "("+func1+")*("+func2+")";
	}
	
	//no rule available for integrand
}
