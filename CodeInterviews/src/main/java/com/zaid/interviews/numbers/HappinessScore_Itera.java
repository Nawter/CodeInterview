package com.zaid.interviews.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HappinessScore_Itera {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> data = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			data.add(in.nextInt());
		}
		TreeSet<Integer> set = getSums(data);
		int count = 0;
		for (Integer integer : set) 
		{
			if (isPrime(integer)) 
			{
				count++;
			}
		}
		System.out.println(count);
		in.close();
	}
	public static boolean isPrime(int n) 
	{
		if (n < 2) 
		{
			return false;
		}
		if (n == 2)
		{
			return true;
		}
		if (n % 2 == 0)
		{
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) 
		{
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static TreeSet<Integer> getSums(List<Integer> array) {
		TreeSet<Integer> result = new TreeSet<Integer>();
        for (int i = 1; i < (1 << array.size()); i++) 
        {
        	//System.out.println("i-1:"+i);
            int sum = 0;
            for (int j = 0; j < array.size(); j++) 
            {
                if ((i >> j & 1) == 1) 
                {
                    sum += array.get(j);
                    //System.out.println("i-2:"+i);
                }
            }
            result.add(sum);
        }
		
		return result;		
		
		
		
	}
}
