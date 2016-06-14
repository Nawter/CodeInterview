package com.zaid.interviews.numbers;

public class WaysToCoinChangeRecursiveOne 
{
	public static int recursive(int n, int[] s, int i) 
	{
		if (n < 0) 
		{
			return 0;
		}
		if (n == 0) 
		{
			return 1;
		}
		// means coins over and n>0 so no solution
		if (i == s.length && n > 0) 
		{
			return 0;
		}
		return recursive(n - s[i], s, i) + recursive(n, s, i + 1);
	}
	public static void main(String[] args)
	{
		int s[] = {1, 2, 3};	   
	    int n = 4;
		System.out.println("number of ways:"+recursive(n, s, 0));	
	}
}
