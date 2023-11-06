package practicos.practico6.exceptions;

/**
 * Clase CloneTreeException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class CloneTreeException extends Exception {
	
	/**
	 * Excepción ejecutada en caso de que suceda un error al clonar el árbol.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public CloneTreeException(String s) {
		super(s);
	}
}
