package sortingandstuff;

public class SelectionSort {
public static void main(String[] args){
int current=0;
int[] a={6,13,2,15,3};	
for (int i =1;i<a.length;i++){

		for (int d=0;d>=i;d++){
			
			if (!(a[i]<a[d-1])){
				int temp=a[d];
				a[d]=a[i];
				a[i]=temp;
			}
			
			
				
			}
		}
	System.out.println(a[0]+","+a[1]+a[2]+","+a[3]+","+a[4]);}
}





