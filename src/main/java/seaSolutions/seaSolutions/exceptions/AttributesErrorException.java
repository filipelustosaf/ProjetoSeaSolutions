package seaSolutions.seaSolutions.exceptions;

public class AttributesErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AttributesErrorException(String resposta) {
		super(resposta);
	}
}
