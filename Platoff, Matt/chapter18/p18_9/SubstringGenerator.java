package p18_9;

import java.util.ArrayList;

public class SubstringGenerator {
	static ArrayList<String> subs = new ArrayList<String>();
	public static void main(String[] args) {
		
		System.out.println(getSubstrings("eat"));
		
	}

	public static ArrayList<String> getSubstrings(String x) {
		
		if (x.length() == 0){
			subs.add("");
			return subs;
		}
		
		else{ 
		subs.add(x);
			for (int i=x.length()-1;i>0;i--){
				
				x=x.substring(0, i);
				subs.add(x);
			}
			
			return getSubstrings(x.substring(1));
		
			
		
		
		}

		
//		for(int beg = 0; beg < x.length(); beg++)
//			for(int end = beg; end <=x.length(); end++)
//				subs.add(x.substring(beg, end));
//		
//		return subs;
	
		
	

	}}
