package validatedInput;

import java.util.Scanner;

import validatedInput.Validator;

public class ValidatedInput {
	private Scanner scan = new Scanner(System.in);;

	// prompt is validator.prompt(), error on invalid input is validator.error()
	// validity check is validator.isValid(...)
	// continues prompting and displaying error until valid input is obtained
	// returns valid input
	public int getInt(Validator<Integer> validator) {
		System.out.println(validator.prompt());
		String num = scan.nextLine();

		while (!validator.isValid(num)) {

			System.out.println(validator.error());
			System.out.println(validator.prompt());
			num = scan.nextLine();
		}

		return Integer.parseInt(num);
	}

	// same as above
	// accepts any integer as valid input
	// hint: use AnyIntegerValidator with the above method
	public int getInt() {
		AnyIntegerValidator valid = new AnyIntegerValidator();
		return getInt(valid);

	}

	// same as above
	// accepts any integer x such that: min <= x <= max
	// precondition: min <= max
	// hint: define a class IntegerRangeValidator to use with the first method
	public int getInt(int min, int max) {
		IntegerRangeValidator valid = new IntegerRangeValidator(min, max);

		return getInt(valid); // TODO: implement method
	}
	public boolean password(Validator<String> valid,int attempts){
		for (int x=attempts;x>0;x--){
			System.out.println(valid.prompt());
			String word=scan.nextLine();
			if (valid.isValid(word)){
				System.out.println("that is the correct password");
				return true;}
			else 
				System.out.println("that pass word was incorrect you have "+ x+" attempts left");
		}
		System.out.println("you are out of attempts");
		return false;
		
	}
	private void prompt(Validator validator){
		System.out.println(validator.prompt());
		String num = scan.nextLine();

		while (!validator.isValid(num)) {

			System.out.println(validator.error());
			System.out.println(validator.prompt());
			num = scan.nextLine();
		}
	}
	
}
