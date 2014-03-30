package sortingandstuff;

public class MergeSort {
public static int [] merge(int[] a, int[] b){
	int[] temp=new int[a.length+b.length];
	for (int x=0,y=0,z=0;x<a.length&&y<b.length;z++){
		if (a[x]<=b[y]){
			temp[z]=a[x++];
		}
		else 
			temp[z]=b[y++];
	}
	return temp;
	
	
}
}
