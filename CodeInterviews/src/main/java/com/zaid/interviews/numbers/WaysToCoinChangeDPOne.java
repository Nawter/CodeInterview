package com.zaid.interviews.numbers;


public class WaysToCoinChangeDPOne {
	public static int dynamic(int[] s, int m,int n) {
	
		int i, j, x, y;
		 
	    // We need n+1 rows as the table is consturcted in bottom up manner using 
	    // the base case 0 value case (n = 0)
	    int[][] table=new int[n+1][m];
	    
	    // Fill the enteries for 0 value case (n = 0)
	    for (i=0; i<m; i++)
	        table[0][i] = 1;
	 
	    // Fill rest of the table enteries in bottom up manner  
	    for (i = 1; i < n+1; i++)
	    {
	        for (j = 0; j < m; j++)
	        {
	            // Count of solutions including S[j]
	            x = (i-s[j] >= 0)? table[i - s[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    for (j = 0; j < m; j++)
	    {
	        for (i = 0; i < n+1; i++)
	        {	           
	            System.out.print(" "+table[i][j]);
	        }
	        System.out.println();
	    }	    
	    return table[n][m-1];	
	}
	
public static void main(String[] args)
{
	int s[] = {1, 2, 3};
    int m = s.length;
    int n = 4;
	System.out.println("number of ways:"+dynamic(s, m, n));	
}
}