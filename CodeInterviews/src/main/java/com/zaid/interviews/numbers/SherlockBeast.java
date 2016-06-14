package com.zaid.interviews.numbers;

import java.util.Arrays;

public class SherlockBeast 
{
    public int fiveCount(int num) 
    {
        int fives = num;
        while (fives >= 0 && (num - fives) <= num) 
        {
            if(fives % 3 == 0 && (num - fives) % 5 == 0) 
            {
                return fives;
            }
            fives -= 5;
        }
        return -1;
    }

    public String generateOutput(int num, int fives) 
    {
        if(fives == -1) 
        {
            return "-1";
        }
        else 
        {
            char[] fivess = new char[fives];
            char[] threes = new char[num - fives];
            Arrays.fill(fivess, '5');
            Arrays.fill(threes, '3');
            return new StringBuilder().append(fivess).append(threes).toString();
        }
    }
}
