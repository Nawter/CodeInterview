package com.zaid.interviews.numbers;

import java.util.Scanner;
import org.junit.Test;


public class TestSherlockBeast 
{
	@Test
	public void testSherlockBeast()
	{
		SherlockBeast sb=new SherlockBeast(); 
		Scanner stdin = new Scanner(System.in);
	        int tests = stdin.nextInt();
	        for(int i = 0; i < tests; i++) 
	        {
	        	int num = stdin.nextInt();        
	            int fives = sb.fiveCount(num);
	            System.out.println(sb.generateOutput(num, fives));
	        }
	        stdin.close();
	}
}
