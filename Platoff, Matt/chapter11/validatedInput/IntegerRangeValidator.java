package validatedInput;

public class IntegerRangeValidator implements Validator<Integer> {
	private int min, max;

	public IntegerRangeValidator(int min, int max) {
		this.min = min;
		this.max = max;

	}

	public String error() {
		return "Input is not within range";
	}

	public String prompt() {
		return "Enter an integer.";
	}

	public boolean isValid(String value) {
		try {
			int num = Integer.parseInt(value);
			if (num <= max && num >= min)
				return true;
			else
				return false;

		} catch (NumberFormatException e) {
			return false;
		}

	}

}
