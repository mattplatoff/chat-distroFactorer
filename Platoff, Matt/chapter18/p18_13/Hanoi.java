package p18_13;

public class Hanoi {
	public static void main(String[] args){
		move(1,3,3);
	}
	
//	Move a disk from peg 1 to peg 3.
//	Move a disk from peg 1 to peg 2.
//	Move a disk from peg 3 to peg 2.
//	Move a disk from peg 1 to peg 3.
//	Move a disk from peg 2 to peg 1.
//	Move a disk from peg 2 to peg 3.
//	Move a disk from peg 1 to peg 3.
	public static void move(int source, int target, int disks) {
		int peg1=source,peg2=6-(source+target),peg3=target;
		if (source > 3 || source < 1 || target < 1 || target > 3)
			throw new IndexOutOfBoundsException();
		else {
			if (disks==1)
				System.out.println("move disk from "+source+" to "+target);
			else {
				
				 {
				      move(peg1, peg2, disks-1);
				      System.out.println(  "move disk from " + target + " to " + source);
				      move(peg2, peg3,  disks-1);
				     
				    }
			}

		}
	}
}
