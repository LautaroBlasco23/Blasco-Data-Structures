package practicos.practico6.exceptions;
/**
 * Clase EmptyQueueException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class EmptyQueueException extends Exception {
	
	/**
	 * Excepción ejecutada cuando la cola está vacía.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public EmptyQueueException(String s) {
		super(s);
	}
}
