package p18_9;

import java.util.ArrayList;

public class SubstringGenerator {
	private static ArrayList<String> subs = new ArrayList<String>();
	public static void main(String[] args) {
		System.out.println(getSubstrings("eat"));
		
	}

	public static ArrayList<String> getSubstrings(String x) {
//		
//		if (x.length() == 0){
//			subs.add("");
//			
//		return subs;
//		}
//		
//		if (x.length()==1){
//		subs.add(x);
//			return getSubstrings(x.substring(0, x.length()-1));
//		}
//		else 
//			
//		{
//		subs.add(x);
//		return getSubstrings(x.substring(1));
//		

		
		for(int beg = 0; beg < x.length(); beg++)
			for(int end = beg; end <=x.length(); end++)
				subs.add(x.substring(beg, end));
		
		return subs;
		}
		
		
		

	}
