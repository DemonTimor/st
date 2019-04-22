package pkg;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BackPackTest {
	
	private BackPack backPack;
	
	PrintStream print = null;
	
	ByteArrayOutputStream output = null;
	
	String str;
	
	Class bpClass;
	
	Method method;
	
    @Before
    public void setUp() throws Exception {
    	
        backPack = new BackPack();
        
        output = new ByteArrayOutputStream();
        
        print = System.out;
        
        System.setOut(new PrintStream(output));
        
        bpClass = backPack.getClass();
        
        method = bpClass.getDeclaredMethod("main", new Class[]{String[].class});
    }
    
    @After
    public void tearDown() throws Exception {
    	
        System.setOut(print);
    }
    
    @Test
    public void testBackPack() throws Exception{
    	
    	str = new String("0\t0\t4\t4\t4\t4\t4\t4\t4\t4\t\r\n0\t0\t4\t5\t5\t5\t9\t9\t9\t9\t\r\n0\t0\t4\t5\t6\t6\t9\t10\t11\t11\t\r\n");
    	
    	method.invoke(null, new Object[]{new String[] {}});
    	
    	assertEquals(str, output.toString());
    }

}
