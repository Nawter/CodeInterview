package com.zaid.interviews.numbers;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestNumberPowerOfTwo 
{
	@Test
	public void testisPowerOfTwo()
	{
		IsPowerOfTwo test=new IsPowerOfTwo();
		assertEquals(true, test.isPowerOfTwo(2));
	}

}
