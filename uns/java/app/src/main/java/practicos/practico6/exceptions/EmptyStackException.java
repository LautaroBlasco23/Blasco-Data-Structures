package practicos.practico6.exceptions;
/**
 * Clase EmptyStackException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class EmptyStackException extends Exception {
	
	/**
	 * Excepción ejecutada si se desea realizar la operacion 
	 * pop o top de una pila vacia.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public EmptyStackException(String s) {
		super(s);
	}
}
