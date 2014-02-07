package p18_9;

import java.util.ArrayList;

public class SubstringGenerator {
	static ArrayList<String> subs = new ArrayList<String>();
	public static void main(String[] args) {
		for (String s : getSubstrings("eat"))
			System.out.println(s);
		System.out.println(getSubstrings("eat").size());
	}

	public static ArrayList<String> getSubstrings(String x) {
		
		if (x.length() == 0){
			subs.add("");
			
		return subs;
		}
		else {
		subs.add(x);
		return getSubstrings(x.substring(0,x.length()-1));
			
		
		}
		
		
		

	}
}