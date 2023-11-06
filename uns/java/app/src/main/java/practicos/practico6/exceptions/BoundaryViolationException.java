package practicos.practico6.exceptions;
/**
 * Clase BoundaryViolationException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class BoundaryViolationException extends Exception {
	
	/**
	 * Excepción ejecutada al exceder el rango aceptable de la estructura.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public BoundaryViolationException(String s) {
		super(s);
	}
	
}
