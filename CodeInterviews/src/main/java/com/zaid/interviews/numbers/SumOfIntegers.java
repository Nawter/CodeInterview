package com.zaid.interviews.numbers;

import java.util.Scanner;

public class SumOfIntegers 
{
	public void sumOfIntegers()
	{
		Scanner scanner=new Scanner(System.in);
		int numberOfIntegers=scanner.nextInt();
		int sum=0;
		for(int i=0;i<numberOfIntegers;i++)
		{
			sum+=scanner.nextInt();
		}
		System.out.println("The sum is:"+sum);
	}
}
