package practicos.practico6.exceptions;
/**
 * Clase InvalidPositionException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class InvalidPositionException extends Exception {

	/**
	 * Excepción ejecutada si la posición es inválida.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public InvalidPositionException(String s) {
		super(s);
	}

}
