package practicos.practico4.DNodo;

import practicos.practico4.interfaces.Position;

public class Dnodo<E> implements Position<E> {
    public E element;
    public Dnodo<E> siguiente;
    public Dnodo<E> anterior;

    // Inicialización del nodo 
    public Dnodo(E element) {
        this.element = element;
        this.siguiente = null;
        this.anterior = null;
    }

    // Setters
    
    public void establecerSiguiente(Dnodo<E> siguienteNodo) {
        this.siguiente = siguienteNodo;
    }

    public void establecerAnterior(Dnodo<E> nodoPrevio) {
        this.anterior = nodoPrevio;
    }

    @Override
    public E element() {
        return this.element;
    }

    public Dnodo<E> siguiente() {
        return this.siguiente;
    }

    public Dnodo<E> anterior() {
        return this.anterior;
    }

    public boolean equals(Dnodo<E> nodo) {
      return nodo.element() == this.element();
    }
}
