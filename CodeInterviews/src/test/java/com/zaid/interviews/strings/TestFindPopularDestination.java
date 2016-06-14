package com.zaid.interviews.strings;

import java.util.Scanner;

import org.junit.Test;

public class TestFindPopularDestination 
{
	@Test
	public void testfindPopularDestination()
	{
		FindPopularDestination fpd =new FindPopularDestination();
		Scanner inNum = new Scanner(System.in);
		Scanner inString = null;
		int numDestination = inNum.nextInt();
		String[] destinations=new String[numDestination];
		for(int i=0;i<numDestination;i++)
		{
			inString = new Scanner(System.in);
			destinations[i]= inString.next();
		}		
		fpd.findPopularDestination(numDestination, destinations);		
	}	
}
