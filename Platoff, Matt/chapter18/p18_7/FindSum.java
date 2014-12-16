package p18_7;

public class FindSum
{
	public static void main(String[] args)
	{
		int[] array = {4,1,7,1,0,9,7};
		System.out.println(findSum(array));
	}
	
	public static int findSum(int[] a)
	{
		return findSum(a,0);
	}
	
	private static int findSum(int[] a, int start)
	{
		if (start == a.length)
	        return 0;
	    
	    else
	        return a[start] + findSum(a, start + 1);
	}
}
