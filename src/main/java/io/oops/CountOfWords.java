package io.oops;

import java.util.HashMap;
import java.util.*;


public class CountOfWords {

	public static void printWord(String a)
	{
		int count=0;
		String paragraph = "abc def def degh thr hhe";
		String[] str= paragraph.split(" ");		
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for(int i=0; i<str.length; i++)
		{
			if(hashMap.containsKey(str[i]))
			{
				count = hashMap.get(str[i]);
				hashMap.put(str[i], count+1);
			}
			
			else {
				hashMap.put(str[i], 1);
			}
		}
		System.out.println(hashMap.get(a));
		
	}
	
//	public static Object getKeyFromValue(Map hm, Object value) {
//	    for (Object o : hm.keySet()) {
//	      if (hm.get(o).equals(value)) {
//	        return o;
//	      }
//	    }
//	    return 0;
//	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the word:");
		String word = s.next();
		s.close();
		CountOfWords.printWord(word);
		
		
	}

}
