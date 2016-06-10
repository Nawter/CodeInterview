package com.zaid.interviews.numbers;

public class IsPowerOfTwo 
{
	public boolean isPowerOfTwo(int number)
	{
		return (number > 0) && ( (number & (number - 1) ) ==0);
	}
}
