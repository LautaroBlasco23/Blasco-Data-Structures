package practicos.practico4.interfaces;

import java.util.Iterator;

import practicos.practico4.TDALista;
import practicos.practico4.DNodo.Dnodo;

public class IteradorDeListaDE<E> implements Iterator<E> {
    private Dnodo<E> currentNode;
    
    public IteradorDeListaDE(TDALista<E> lista) {
        if (lista.isEmpty()) {
            this.currentNode = null;
        } else {
            this.currentNode = lista.first();
        }
    }

    public boolean hasNext(){
        if (this.currentNode != null) {
            return true;
        } else {
            return false;
        }
    }

    public E next() {
        // Obtenemos el elemento del nodo en el que está posicionado actualmente el iterador.
        E elemento = this.currentNode.element();
        // Asignamos el nodo actual al siguiente nodo en la lista.
        this.currentNode = this.currentNode.siguiente();
        // Devolvemos el elemento.
        return elemento;
    }
}
