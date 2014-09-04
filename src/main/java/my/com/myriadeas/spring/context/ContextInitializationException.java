package my.com.myriadeas.spring.context;

public class ContextInitializationException extends RuntimeException {

	private static final long serialVersionUID = -5327735663626745612L;

	public ContextInitializationException(String msg) {
		super(msg);
	}

	public ContextInitializationException(String msg, Throwable e) {
		super(msg, e);
	}
}
