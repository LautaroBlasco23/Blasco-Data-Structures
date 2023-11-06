package practicos.practico6.exceptions;
/**
 * Clase EmptyListException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class EmptyListException extends Exception {
	
	/**
	 * Excepción ejecutada cuando la lista está vacía.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public EmptyListException(String s) {
		super(s);
	}
}
