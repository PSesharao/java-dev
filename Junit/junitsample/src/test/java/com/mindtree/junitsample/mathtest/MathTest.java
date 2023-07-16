package com.mindtree.junitsample.mathtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		//System.out.println("Hello World !!");
		Math math = new Math();
		int actual = math.add(1, 5 );
		int expected = 7;
		assertEquals("The add method produced wrong results", expected,actual);
		//assertEquals
	}
	
/*
	@Test
	public void testDiv() {
		//fail("Not yet implemented");
		//System.out.println("Hello World !!");
		Math math = new Math();
		asser
		
	}
*/
}
