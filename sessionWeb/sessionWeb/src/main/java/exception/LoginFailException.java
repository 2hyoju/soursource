package exception;

public class LoginFailException extends Exception{
	public LoginFailException() {}
	public LoginFailException(String failMessage) {
		super(failMessage);
	}
}
