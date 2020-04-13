package wwwordz.shared;

public class WWWordzException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public WWWordzException() {
		super();
	}
	
	public WWWordzException(String message) {
		super(message);
	}
	
	public WWWordzException(String message, Throwable cause) {
		super(message, cause);
	}

	public WWWordzException(Throwable cause) {
		super(cause);
	}
}
