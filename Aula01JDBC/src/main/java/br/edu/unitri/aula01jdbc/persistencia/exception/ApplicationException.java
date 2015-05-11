package br.edu.unitri.aula01jdbc.persistencia.exception;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
