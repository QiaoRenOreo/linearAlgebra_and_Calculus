package ss.week4.test;

import org.junit.Test;
import ss.week4.math.Exponent;
import ss.week4.math.LinearProduct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExponentTest {

    public static final int CONSTANT_VALUE = 35;//x=35
    private static final double DELTA = 1e-15;

    @Test
    public void testApply() {
        assertEquals(1, new Exponent(0).apply(CONSTANT_VALUE), DELTA);
        //35^0=1
        assertEquals(35, new Exponent(1).apply(CONSTANT_VALUE), DELTA);
        //35^1=35
        assertEquals(1225, new Exponent(2).apply(CONSTANT_VALUE), DELTA);
        //35^2=1225
    }

    @Test
    public void testDerivative() {
        Exponent exponent = new Exponent(3);//power=3
        assertTrue(exponent.derivative() instanceof LinearProduct);
        assertEquals(12, exponent.derivative().apply(2), DELTA);
        //function=2^3 derivative=3*(2^(3-1))=12
    }
    
    @Test
    public void testIntegrand()
    {
    	Exponent exponent = new Exponent(3);
    	assertTrue(exponent.integrand() instanceof LinearProduct);
    	assertEquals(4, exponent.integrand().apply(2), DELTA);
    	// 1/(3+1)*2^(3+1)=(1/4)*16=4
    }
}
