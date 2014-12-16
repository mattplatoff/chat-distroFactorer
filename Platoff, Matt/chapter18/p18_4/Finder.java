package p18_4;

public class Finder
{
	public static void main(String[] args)
	{
	    System.out.println(find("mississippi","ipp"));
	}
	
	public static boolean find(String toSearch, String toFind)
	{
	    if (toSearch.startsWith(toFind))
	    	return true;
	    else if (toSearch.length()==toFind.length())
	    	return false;
	    toSearch=toSearch.substring(1);
	
	   return  find(toSearch,toFind);
	    
	
	}
}
