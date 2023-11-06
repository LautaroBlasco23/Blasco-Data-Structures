package practicos.practico6.exceptions;

/**
 * Clase AddNodeException.
 * @author Ezequiel Ramírez Beltrán.
 * @author Dmytro Shkolyar. 
 */
public class AddNodeException extends Exception{
	
	/**
	 * Excepción ejecutada en caso de que suceda un error al agregar un nuevo archivo al árbol.
	 * @param s: mensaje que le queremos mandar al constructor de Exception.
	 */
	public AddNodeException (String s) {
		super(s);
	}
}
