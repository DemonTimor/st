package pkg;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintPrimesTest {

	private PrintPrimes printprimes;

    PrintStream print = null;
    
    ByteArrayOutputStream output = null;
    
    String str;
    
    Class ppClass;
    
    Method method;

    @Before
    public void setUp() throws Exception {
    	
        printprimes = new PrintPrimes();
        
        output = new ByteArrayOutputStream();
        
        print = System.out;
        
        System.setOut(new PrintStream(output));
        
        ppClass = printprimes.getClass();
        
        method = ppClass.getDeclaredMethod("main", new Class[]{String[].class});
    }
    
    @After
    public void tearDown() throws Exception {
    	
        System.setOut(print);
    }
    
    @Test
    public void testArgvNumber() throws Exception {
    	
        str = new String("Usage: java PrintPrimes v1 \r\n");
        
        method.invoke(null, new Object[]{new String[]{}});
        
        assertEquals(str, output.toString());
    }
    
    @Test
    public void testArgvClass() throws Exception {
    	
        str = new String("Entry must be a integer, using 1.\r\nPrime: 2\r\n");
        
        method.invoke(null, new Object[]{new String[]{"a"}});
        
        assertEquals(str, output.toString());
    }
    
    @Test
    public void testPrintPrimes() throws Exception {
    	
    	str = new String("Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n");
    	
    	method.invoke(null, new Object[]{new String[]{"3"}});
        
        assertEquals(str, output.toString());
    }
}
