package com.zaid.interviews.numbers;

public class WaysToCoinChangeRecursiveTwo 
{
	public static int recursive(int[] s,int m, int n) 
	{
		 // If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return recursive( s, m - 1, n ) + recursive( s, m, n-s[m-1] );
	}
	public static void main(String[] args)
	{
		int s[] = {1, 2, 3};	   
	    int n = 4;
		System.out.println("number of ways: "+recursive(s, s.length, n));	
	}
}
