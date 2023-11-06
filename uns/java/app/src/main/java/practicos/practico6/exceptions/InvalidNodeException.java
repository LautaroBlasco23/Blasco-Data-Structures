package practicos.practico6.exceptions;
/**
 * Clase InvalidNodeException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class InvalidNodeException extends Exception{
	
	/**
	 * Excepción ejecutada si el nodo que se desea obtener, no es el correcto.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public InvalidNodeException (String s) {
		super(s);
	}
}
