package exceptiondemo;

@SuppressWarnings("serial")
public class EvenNumberException extends Exception{
	public EvenNumberException(String message)
	{
		super(message);
	}
}
