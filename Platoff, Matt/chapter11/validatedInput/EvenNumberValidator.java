package validatedInput;

public class EvenNumberValidator implements Validator<Integer> {
	public String error()
	{
		return "Input is not an even integer.";
	}

	public String prompt()
	{
		return "Enter an integer.";
	}

	public boolean isValid(String value)
	{
		try
		{
			if (Integer.parseInt(value)%2==0)
			
			return true;
			else return false;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}
