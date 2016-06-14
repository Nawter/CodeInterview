package com.zaid.interviews.numbers;

import java.util.*;

public class HappinessScore_Rec {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> data = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			data.add(in.nextInt());
		}
		TreeSet<Integer> set = getSums(data, 0, 0);
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
	public static TreeSet<Integer> getSums(List<Integer> array, int start, int sum) 
	{
		TreeSet<Integer> result = new TreeSet<Integer>();
		if (array.size() == start) 
		{			
			return result;
		}
		int val = sum + array.get(start);
		result.add(val);
		result.addAll(getSums(array, start + 1, val)); 
		result.addAll(getSums(array, start + 1, sum));
		return result;
	}
}
