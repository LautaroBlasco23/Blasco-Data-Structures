package practicos.practico3;

import java.util.ArrayList;
import java.util.Stack;

public class EjerciciosTP3<E> {
    // ------------------------------------------------------------------------------------------------
    // EJERCICIO 1
    // ------------------------------------------------------------------------------------------------
    public boolean ej1aPertenece(ArrayList<E> miLista, E e) {
        for (int i = 0; i < miLista.size(); i++) {
            if (miLista.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean ej1bAlMenosNVeces(ArrayList<E> miLista, E e, int n) {
        int cant = 0;
        for (int i = 0; i < miLista.size(); i++) {
            if (miLista.get(i) == e) {
                cant++;
            }
            if (cant == n) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------------------------------------
    // EJERCICIO 2
    // ------------------------------------------------------------------------------------------------
    public ArrayList<E> ej2aIntercalar(ArrayList<E> lista1, ArrayList<E> lista2) {
        // Creamos lista resultado para el return de la función.
        ArrayList<E> listaResultado = new ArrayList<>();
        
        // Agregamos a nuestra lista resultado todos los elementos que nos pasaron como parametro. 
        int i = 0;
        while(i < lista1.size() || i < lista2.size()) {
            if (i < lista1.size()) {
                listaResultado.add(lista1.get(i));
            }
            if (i < lista2.size()) {
                listaResultado.add(lista2.get(i));
            }
            i++;
        }

        return listaResultado;
    }

    // Ejercicio 2B:
    public ArrayList<Integer> ej2bIntercalarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        // Generamos una listaResultado para el return de la función.
        ArrayList<Integer> listaResultado = new ArrayList<>();

        // Ingresamos a nuestra listaResultado todos los elementos NO repetidos
        // de las dos listas que nos pasaron como parametros.
        int i = 0;
        while(i < lista1.size() || i < lista2.size()) {
            if (i < lista1.size()) {
                // Solo insertamos si el elemento NO está en la lista.
                if (!listaResultado.contains(lista1.get(i))) {
                    listaResultado.add(lista1.get(i));
                }
            }
            if (i < lista2.size()) {
                // Solo insertamos si el elemento NO está en la lista.
                if (!listaResultado.contains(lista2.get(i))) {
                    listaResultado.add(lista2.get(i));
                }
            }
            i++;
        }
                
        // Una vez que tenemos todos los elementos ingresados en la Lista. Procedemos a ordenarlos.
        for (i = 0; i < listaResultado.size() - 1; i++) {
            for (int j = i + 1; j < listaResultado.size(); j++) {
                if (listaResultado.get(i) > listaResultado.get(j)) {
                    int aux = listaResultado.get(i);
                    listaResultado.set(i, listaResultado.get(j));
                    listaResultado.set(j, aux);
                }
            }
        }

        return listaResultado;
    }

	// ------------------------------------------------------------------------------------------------
    // EJERCICIO 3
    // ------------------------------------------------------------------------------------------------	
    public void ej3Invertir(ArrayList<E> miLista) {
        Stack<E> pilaAux = new Stack<E>();
        for (int i = 0; i < miLista.size(); i++) {
            pilaAux.push(miLista.get(i));
        }
        int i = 0;
        while (!pilaAux.isEmpty()) {
            miLista.set(i, pilaAux.pop());
            i++;
        }
    }
	
	// ------------------------------------------------------------------------------------------------
    // EJERCICIO 4
    // ------------------------------------------------------------------------------------------------
    public boolean ej4RespetaFormato(ArrayList<E> lista1, ArrayList<E> lista2) {
        // Empezamos comprobando que lista2 tenga exactamente la mitad de elementos que lista1.
        boolean esCorrecto = (lista2.size() == (lista1.size() / 2));

        for (int i = 0; i < lista1.size() && esCorrecto; i++) {
            if (i < lista2.size()) { // Recorremos la lista2 de forma creciente. hasta llegar a su último indice posible.
                esCorrecto = lista1.get(i).equals(lista2.get(i));
            } else { // una vez llegamos al último indice, empezamos a recorrer el arreglo de forma inversa. 
                esCorrecto = lista1.get(i).equals(lista2.get(lista1.size() - 1 - i));
            }
        }
        return esCorrecto;
    }

    // ------------------------------------------------------------------------------------------------
    // EJERCICIO 5
    // ------------------------------------------------------------------------------------------------
    public void ej5Eliminar(ArrayList<E> lista1, ArrayList<E> lista2) {
        for (int i = 0; i < lista2.size(); i++) {
            for (int j = 0; j < lista1.size(); j++) {
                // Vamos por cada elemento de la lista1, 
                // mirando si es igual al elemento que tenemos actualmente de la lista2.
                if (lista1.get(j).equals(lista2.get(i))) {
                    // lo sacamos usando el indice.
                    lista1.remove(j);
                }
            }
        }

        // Ingresamos de forma invertida los elementos de lista2 en lista1.
        for (int i = lista2.size() - 1; i >= 0; i--) {
            lista1.add(lista2.get(i));
        }
    } 
}