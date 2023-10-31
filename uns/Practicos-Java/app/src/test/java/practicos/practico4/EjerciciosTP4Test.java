package practicos.practico4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import practicos.practico4.interfaces.PositionList;
/*
Estos tests asumen que los ejercicios 3 y 4 fueron resueltos mediante una clase EjerciciosTP4
con un método público para cada ejercicio.
 
public class EjerciciosTP4<E> {
	ej3Pertenece
	ej4Duplicados
}

Los ejercicios 1 y 2 se asumen fueron resueltos mediantes una clase DoubleLinkedList.
*/

public class EjerciciosTP4Test {
	
	private Lista<Integer> ejerciciosInt;
	    
    @Before
    public void setUp() {
        ejerciciosInt = new Lista<>();
    }

	@Test
	public void testEj2agregar() {
		Lista<Integer> l = new Lista<>();
		try {
			// we've to use a catch statement, bc if list.len() == 1 the method won't work.
			l.ej2Modificar(1,2);
		} catch (Exception e) {
			// pass
		}
		
		int[] expected = {2, 1};
		
		int i = 0;
		for(int e : l) {
			assertEquals(expected[i], e);
			i++;
		}
		
		assertEquals(2, l.size());
		
		try {
			// we've to use a catch statement, bc if list.len() == 1 the method won't work.
			l.ej2Modificar(3,4);
		} catch (Exception e) {
			// pass
		}

		int[] expected2 = {2, 3, 4, 1};
		
		i = 0;
		for(int e : l) {
			assertEquals(expected2[i], e);
			i++;
		}
		
		try {
			// we've to use a catch statement, bc if list.len() == 1 the method won't work.
			l.ej2Modificar(5,6);
		} catch (Exception e) {
			// pass
		}
		int[] expected3 = {2, 5, 3, 4, 6, 1};
		
		i = 0;
		for(int e : l) {
			assertEquals(expected3[i], e);
			i++;
		}
	}
		
	@Test
	public void testEj3Pertenece() {
		Lista<Integer> l = new Lista<Integer>();
		l.addLast(1);
		l.addLast(3);
		l.addLast(5);
		l.addLast(7);
		assertTrue(ejerciciosInt.ej3Buscar(l, 3));
		assertTrue(ejerciciosInt.ej3Buscar(l, 7));
		assertFalse(ejerciciosInt.ej3Buscar(l, 4));;
	}
	
	@Test
	public void testEj3PerteneceVacio() {
		Lista<Integer> l = new Lista<Integer>();
		assertFalse(ejerciciosInt.ej3Buscar(l, 3));
	}
	
	@Test
	public void testEj3PerteneceEquivalencia() {
		Lista<Persona> ej = new Lista<Persona>();
		
		Lista<Persona> l = new Lista<Persona>();
    	l.addLast(new Persona("Luke"));
    	l.addLast(new Persona("Anakin"));
    	
    	assertTrue("La comparación de elementos debe ser por equivalencia", ej.ej3Buscar(l, new Persona("Anakin")));
	}
	
	@Test
	public void testEj4Duplicados() {
		Lista<Integer> l = new Lista<Integer>();
		l.addLast(1);
		l.addLast(3);
		l.addLast(5);
		l.addLast(7);
		
		int[] expected = {1, 1, 3, 3, 5, 5, 7, 7};
		
		int i = 0;
		for(int e : ejerciciosInt.ej4Repetir(l)) {
			assertEquals(expected[i], e);
			i++;
		}
	}
	
	@Test
	public void testEj4DuplicadosVacia() {
		Lista<Integer> vacia = new Lista<Integer>();
		assertEquals(0, ejerciciosInt.ej4Repetir(vacia).size());
	}
}

class Persona {
	private String name;
	
	public Persona(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Persona)) {
            return false;
        }
		Persona p = (Persona) o;
         
		return name.equals(p.getName());		
	}
}
