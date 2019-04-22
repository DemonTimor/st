package pkg;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	private BubbleSort bubbleSort;
	
	PrintStream print = null;
	
	ByteArrayOutputStream output = null;
	
	String str;
	
	Class bsClass;
	
	Method method;
	
	@Before
    public void setUp() throws Exception {
    	
        bubbleSort = new BubbleSort();
        
        output = new ByteArrayOutputStream();
        
        print = System.out;
        
        System.setOut(new PrintStream(output));
        
        bsClass = bubbleSort.getClass();
        
        method = bsClass.getDeclaredMethod("main", new Class[]{String[].class});
    }
	
    @After
    public void tearDown() throws Exception {
    	
        System.setOut(print);
    }
    
    @Test
    public void testBubbleSort() throws Exception {
    	
    	int[] array = new int[]{1, 2, 2, 5, 6};
    	
    	method.invoke(null, new Object[]{new String[]{}});
    	
    	str = Arrays.toString(array) + "\r\n";
    	
    	assertEquals(str, output.toString());
    }
}
