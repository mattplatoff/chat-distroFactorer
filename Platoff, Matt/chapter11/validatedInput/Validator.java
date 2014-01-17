package validatedInput;

public interface Validator<E>
{
	String prompt();
	String error();
	
	boolean isValid(String value);
}
