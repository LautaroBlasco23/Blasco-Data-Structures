package practicos.practico6.exceptions;
/**
 * Clase InvalidNodeLabelException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class InvalidNodeLabelException extends Exception{
	
	/**
	 * Excepción ejecutada si el rótulo del nodo no es el correcto.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public InvalidNodeLabelException (String s) {
		super(s);
	}
}
