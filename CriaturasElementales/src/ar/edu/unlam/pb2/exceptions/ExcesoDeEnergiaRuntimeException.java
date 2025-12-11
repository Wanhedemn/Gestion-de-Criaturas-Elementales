package ar.edu.unlam.pb2.exceptions;

public class ExcesoDeEnergiaRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcesoDeEnergiaRuntimeException(String mensaje) {
		super(mensaje); 
	}
}
