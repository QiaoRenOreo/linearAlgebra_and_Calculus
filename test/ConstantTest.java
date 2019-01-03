package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstantTest {

    private static final double DELTA = 1e-15;
    //(1*10^(-15)) gives accuracy: how many digits should be remained after decimal dot. 
    private static final double CONSTANT_VALUE = Math.PI;
    private Constant constant;

    @Before
    public void setUp() {
        constant = new Constant(CONSTANT_VALUE);
    }

    @Test
    public void testApply() {
    	//example: assertEquals(3.14159, myPi, 0.001); does myPi==3.14159 with accuracy 0.001
        assertEquals(CONSTANT_VALUE, constant.apply(0), DELTA);
        assertEquals(CONSTANT_VALUE, constant.apply(-1), DELTA);
        assertEquals(CONSTANT_VALUE, constant.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(constant.derivative() instanceof Constant);
        assertEquals(0.0, constant.derivative().apply(0), DELTA);
    }
    
    @Test
    public void testIntegrand()
    {
        assertTrue(constant.integrand() instanceof Constant);// instance of Product??
        assertEquals(3*Math.PI, constant.integrand().apply(3), DELTA);
    }
}
