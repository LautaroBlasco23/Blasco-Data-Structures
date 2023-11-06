package practicos.practico6.exceptions;
/**
 * Clase EmptyTreeException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class EmptyTreeException extends Exception {

	/**
	 * Excepción ejecutada si el árbol está vacío.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public EmptyTreeException(String s) {
		super(s);
	}
	
}
