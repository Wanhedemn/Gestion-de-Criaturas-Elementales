package ar.edu.unlam.pb2.exceptions;

public class CriaturaNoRegistradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CriaturaNoRegistradaException(String mensaje) {
		super(mensaje);
	}
}
