package exceptiondemo;

@SuppressWarnings("serial")
public class OddNumberException extends Exception {
	public OddNumberException(String message)
	{
		super(message);
	}
}
