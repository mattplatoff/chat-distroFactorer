package p18_1_and_p18_3;

public class StringReverser
{
	public static void main(String[] args)
	{
	    System.out.println(reverse("wassup"));
	    System.out.println(reverseIteratively("wassup"));
	}
	
	public static String reverse(String toReverse)
	{
		if (toReverse.length()==2)
			 return toReverse=toReverse.substring(1,2)+toReverse.substring(0,1);
		
		else 
			
			toReverse=reverse(toReverse.substring(1))+toReverse.substring(0,1);
		return toReverse;
			
	}
	
	public static String reverseIteratively(String toReverse)
	{
		String reverse ="";
		for (int x=toReverse.length();x>0;x--){
			reverse+=toReverse.substring(x-1,x);
		}
			return reverse;
	}
}