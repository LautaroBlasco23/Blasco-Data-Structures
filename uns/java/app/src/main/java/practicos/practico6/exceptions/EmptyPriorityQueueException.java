package practicos.practico6.exceptions;
/**
 * Clase EmptyPriorityQueueException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class EmptyPriorityQueueException extends Exception {
	
	/**
	 * Excepción ejecutada cuando la cola con prioridad está vacía.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public EmptyPriorityQueueException(String s) {
		super(s);
	}
}
