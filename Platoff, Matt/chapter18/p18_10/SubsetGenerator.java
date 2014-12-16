package p18_10;

import java.util.ArrayList;
import java.util.HashSet;

public class SubsetGenerator
{
	private static ArrayList<String> subs=new ArrayList<String>();
	public static void main(String[] args)
	{
		System.out.println(getSubsets("eat"));
	}

	public static ArrayList<String> getSubsets(String x)
	{
		
		
		if (x.length()==0){
			subs.add(x);
			HashSet hash = new HashSet();
			hash.addAll(subs);
			subs.clear();
			subs.addAll(hash);
			return subs;}
		
			else{
  
				subs.add(x);
	            getSubsets(x.substring(0, x.length()-1)); 
	            getSubsets(x.substring(1, x.length())); 
	            return subs;

		}
		
			
		
	}
}