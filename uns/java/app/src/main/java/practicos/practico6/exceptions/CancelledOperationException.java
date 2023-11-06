package practicos.practico6.exceptions;
/**
 * Clase CancelledOperationException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class CancelledOperationException extends Exception{
	
	/**
	 * Excepción ejecutada en el momento cancelar una operación de la GUI. 
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public CancelledOperationException (String s) {
		super(s);
	}
	
	/**
	 * Excepción ejecutada en el momento cancelar una operación de la GUI. 
	 */
	public CancelledOperationException () {

	}
}
