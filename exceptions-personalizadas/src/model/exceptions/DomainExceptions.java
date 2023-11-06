package model.exceptions;

/*
 * extends Exception - Obrigatório o tratamento da exceção
 * extend RunTimeException - Não obriga a tratar as exceções
 */
public class DomainExceptions extends Exception{

	private static final long serialVersionUID = 1L;

	public DomainExceptions(String msg) {
		super(msg);
	}
}
