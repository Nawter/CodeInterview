package com.zaid.interviews.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;


class DestinationValueCompare implements Comparator<String>
{
	Map<String,Integer> toCompare;
	public DestinationValueCompare(Map toCompare) 
	{
		this.toCompare = toCompare;
	}
	@Override
	public int compare(String searchStringA, String searchStringB) 
	{
		if (toCompare.get(searchStringA) <= toCompare.get(searchStringB)) 
		{
			return -1;
		} else 
		{
			return 1;
		}
	}
}

public class FindPopularDestination 
{	
			public void findPopularDestination(int numDestination,String[] destinations)
			{
				try{
					Map<String, Integer> searchDestination = new HashMap<String, Integer>();			
					DestinationValueCompare dvc = new DestinationValueCompare(searchDestination);
					TreeMap<String, Integer> sortDestination = new TreeMap<String, Integer> (dvc);						
					for(int i=0;i<numDestination;i++)
					{						
						String searchString = destinations[i];
						if(searchDestination.containsKey(searchString))
						{
							Integer val = searchDestination.get(searchString);
							searchDestination.put(searchString, ++val);
						}else
						{
							searchDestination.put(searchString,1);
						}
					}					
					sortDestination.putAll(searchDestination);				
					System.out.println("Best one: "+sortDestination.lastKey());
				}
				catch(InputMismatchException ime)
				{
					ime.printStackTrace();
				}
			}		
	}


