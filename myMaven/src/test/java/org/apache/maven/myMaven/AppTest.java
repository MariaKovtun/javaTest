package org.apache.maven.myMaven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testIsValid()
    {
    	String input = "2[xy]";
    	assertTrue(App.isValid(input));
    	String wrongInput = "2(xy)";
    	assertFalse(App.isValid(wrongInput));
    	String rusInput = "2[абв]";
    	assertFalse(App.isValid(rusInput));
    	
    }
    
    @Test
    public void testUnpack()
    {
    	String input = "2[xy]3[z]";
        String expected="xyxyzzz";
        String actual = App.unpack(input);
        assertEquals("Test is failed", expected, actual);
    }
    
    @Test
    public void testUnpackStrWithBracketsInBrackets()
    {
    	String input = "2[2[x]y3[z]]";
        String expected="xxyzzzxxyzzz";
        String actual = App.unpack(input);
        assertEquals("Test is failed", expected, actual);
    }
	
   
    
   
}
