package exception;

public class LoginFailException extends Exception {
	
	public LoginFailException() {}

	public LoginFailException(String failMessage) {
//		failMessage는 getMessage로 빼옴
		super(failMessage);
	}
	
}
