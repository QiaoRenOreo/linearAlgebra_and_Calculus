package ss.week4.test;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Polynomial;
import ss.week4.math.Sum;
import ss.week4.math.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest 
{
    private static final double DELTA = 1e-15;
    private Polynomial polynomial;

    @Before
    public void setUp() 
    {
    	double[] doubleArray  = new double[]{1.0,2.0,3.0,4.0,5.0};
    	//a0=1.0,a1=2.0,a2=3.0,a4=4.0,a5=5.0
        polynomial = new Polynomial(doubleArray);
    }
    @Test
    public void testApply() 
    {
        assertEquals(1.0, polynomial.apply(0), DELTA);
        assertEquals(3.0, polynomial.apply(-1), DELTA);
        assertEquals(15.0, polynomial.apply(1), DELTA);
    }

    @Test
    public void testDerivative() 
    {
        assertTrue(polynomial.derivative() instanceof Function);
        assertEquals(40.0, polynomial.derivative().apply(1), DELTA);
    }
    
    @Test
    public void testIntegrand()
    {
        assertTrue(polynomial.integrand() instanceof Sum);
        assertEquals(0.0, polynomial.integrand().apply(0), DELTA);
    }

}
