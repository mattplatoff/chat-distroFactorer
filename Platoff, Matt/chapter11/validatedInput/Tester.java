package validatedInput;

public class Tester
{
	public static void main(String[] args)
	{
		ValidatedInput vi = new ValidatedInput();

		// get any integer
		int any = vi.getInt();
		System.out.println("User entered: " + any);
		
		// get integer x such that: 10 <= x <= 50
		int x = vi.getInt(10, 50);
		System.out.println("User entered: " + x);
		
		// TODO: make a new implementation of validator that validates
		//		 input with your choice of criteria (ex: divisible by
		//		 a specified number. Use it to test the method below.
		//int mine = vi.getInt(/* TODO: appropriate parameter */);
		//System.out.println("User entered: " + mine);
	}
}