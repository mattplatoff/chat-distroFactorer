package p18_13;

import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		System.out.println("enter first peg");
		int p1=kb.nextInt();
		System.out.println("enter target peg");
		int p2=kb.nextInt();
		System.out.println("enter num of disks");
		int disks=kb.nextInt();
		move(p1,p2,disks);
	}


	public static void move(int source, int target, int disks) {
		int peg1=source,peg2=6-(source+target),peg3=target;
		if (source > 3 || source < 1 || target < 1 || target > 3)
			throw new IndexOutOfBoundsException();
		else {
			if (disks==1)
				System.out.printf("Move one disk from pole %s to pole %s \n ", source, target);
			else {
				
				 {
				      move(peg1, peg2, disks-1);
				      System.out.printf("Move one disk from pole %s to pole %s \n ", source, target);
				      move(peg2, peg3,  disks-1);
				     
				     
				    }
			}

		}
	}
}
