package marine.etrs.model_Metier.facade.exceptions_business;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}
