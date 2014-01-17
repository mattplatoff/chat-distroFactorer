package validatedInput;

public class SimplePasswordValidator implements Validator<String> {
	private String password;

	public SimplePasswordValidator(String password) {
		this.password = password;

	}

	public String error() {
		return "Incorrect Password";
	}

	public String prompt() {
		return "Enter a password";
	}

	public boolean isValid(String value) {

		if (value.equals(password))

			return true;
		else
			return false;

	}
}
