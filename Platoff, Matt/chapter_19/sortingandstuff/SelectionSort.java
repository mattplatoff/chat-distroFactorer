package sortingandstuff;

public class SelectionSort {
public static int[] selectionSort(int[] a){
    if (a.length==1)
    	return a;
    else
    
	return selectionSortHelper(a.length-1,a);
	
}
private static int[] selectionSortHelper(int start,int[]a){
	int [] sorted = null, unsorted = null;
	if (a.length==1)
		return a;
	
	for (int i=0;i<start;i++)
		sorted[i]=a[i];
	for (int i=a.length;i>start;i--)
		unsorted[i]=a[i];
	
	return a;
	
}
}
