package practicos.practico4;

import java.util.Iterator;

import practicos.practico4.DNodo.Dnodo;
import practicos.practico4.exceptions.BoundaryViolationException;
import practicos.practico4.exceptions.EmptyListException;
import practicos.practico4.exceptions.InvalidPositionException;
import practicos.practico4.exceptions.ListaNoValida;
import practicos.practico4.interfaces.IteradorDeListaDE;
import practicos.practico4.interfaces.Position;
import practicos.practico4.interfaces.PositionList;

// -------------------------------------------------------------------------------------
// Ejercicio 1, implementar TDA lista. (Ejercicio 2 al final de la implementación)
// -------------------------------------------------------------------------------------
public class Lista<E> implements PositionList<E> {
    private Dnodo<E> head;
    private int size;

    public Lista() {
        this.head = null;
        this.size = 0;
    } 

    @Override
    public void addAfter(Position<E> p, E element) throws InvalidPositionException {
        Dnodo<E> posicion = new Dnodo<E>(p.element());

        Dnodo<E> nodoTemporal = this.head;
        while(!nodoTemporal.equals(posicion) && nodoTemporal != null) {
            nodoTemporal = nodoTemporal.siguiente();
        }

        // Si no encontramos la posición que estabamos buscando, devolvemos una excepción.
        if (!nodoTemporal.equals(p)) {
            throw new InvalidPositionException();
        }

        // Acomodamos el nodo anterior
        posicion.establecerSiguiente(nodoTemporal.siguiente());
        posicion.establecerAnterior(nodoTemporal);

        // los dos nodos que rodean al nuevo nodo.
        nodoTemporal.establecerSiguiente(posicion);
        if (nodoTemporal.siguiente() != null) {
            nodoTemporal.siguiente().establecerAnterior(posicion);
        }

        this.size += 1;
    }

    @Override
    public void addBefore(Position<E> p, E element) throws InvalidPositionException {
        Dnodo<E> nodoTemporal = this.head;
        Dnodo<E> posicion = new Dnodo<E>(element);

        // Buscamos el nodo que coincida con la posicion en nuestra lista.
        while(!nodoTemporal.equals(posicion) && nodoTemporal != null) {
            nodoTemporal = nodoTemporal.siguiente();
        }

        // Si no lo encontramos, retornamos una excepción.
        if (!nodoTemporal.equals(posicion)) {
            throw new InvalidPositionException();
        }

        // Acomodamos el nodo que queremos meter a la lista.
        posicion.establecerAnterior(nodoTemporal.anterior());
        posicion.establecerSiguiente(nodoTemporal);

        // ligamos los dos nodos al nodo nuevo.
        nodoTemporal.establecerAnterior(posicion);
        nodoTemporal.anterior().establecerSiguiente(posicion);

        this.size += 1;
    }

    @Override
    public void addFirst(E element) {
      Dnodo<E> nuevoNodo = new Dnodo<E>(element);
      if (this.head != null) {
        // Guardamos en una variable temporal el nodo que ocupaba la primer posición.
        Dnodo<E> nodoTemporal = this.head;
        // Creamos un nodo usando el objeto que nos pasan por parametro, 
        // y lo asignamos como el primero de la lista.
        this.head = nuevoNodo;

        // Establecemos los enlaces entre los nodos.
        this.head.establecerSiguiente(nodoTemporal);
        this.head.establecerAnterior(nodoTemporal.anterior());
        nodoTemporal.establecerAnterior(this.head);
      } else {
        this.head = nuevoNodo;
      }
      this.size += 1;
    }

    @Override
    public void addLast(E element) {
        Dnodo<E> nuevoLast = new Dnodo<E>(element);
        try {
            Dnodo<E> nodoTemporal = this.head;
            if (nodoTemporal == null) {
              this.head = nuevoLast;
            } else {
              while (nodoTemporal.siguiente() != null) {
                  nodoTemporal = nodoTemporal.siguiente();
              }
              // establecemos como siguiente del último nodo al nuevo nodo que queremos ingresar.
              nodoTemporal.establecerSiguiente(nuevoLast);
              nuevoLast.establecerAnterior(nodoTemporal);
              // establecemos como previo al primer nodo al último nodo que queremos ingresar.
              this.head.establecerAnterior(nuevoLast);
            }
        } catch (EmptyListException e) {
            this.head = nuevoLast;
        }
        this.size += 1;
    }

    @Override
    public Dnodo<E> first() throws EmptyListException {
        if (this.head == null) {
          throw new EmptyListException();
        }
        return this.head;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<E> iterator() {
        IteradorDeListaDE<E> iterador =  new IteradorDeListaDE<E>(this);
        return iterador;
    }

    @Override
    public Dnodo<E> last() throws EmptyListException {
        if (this.size() > 0) {
            return this.head.anterior();
        }
        throw new EmptyListException();
    }

    @Override
    public Dnodo<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        Dnodo<E> nodoTemporal = this.head;
        Dnodo<E> posicion = new Dnodo<E>(p.element());

        while (nodoTemporal != null && !nodoTemporal.equals(posicion)) {
            nodoTemporal.siguiente();
        }

        // si el nodoTemporal nos quedó nulo, entonces la posicion que nos dieron es invalida.
        if (nodoTemporal == null) {
            throw new InvalidPositionException();
        }

        return nodoTemporal.siguiente();
    }

    @Override
    public Iterable<Position<E>> positions() {
      Lista<Position<E>> nuevaLista = new Lista<Position<E>>();
      for (E elemento: this) {
        Position<E> position = new Dnodo<E>(elemento);  
        nuevaLista.addLast(position);
      }
      return nuevaLista;
    }

    @Override
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        Dnodo<E> nodoTemporal = this.head;
        Dnodo<E> posicion = new Dnodo<E>(p.element());

        while (nodoTemporal != null && !nodoTemporal.equals(posicion)) {
            nodoTemporal.anterior();
        }

        // si el nodoTemporal nos quedó nulo, entonces la posicion que nos dieron es invalida.
        if (nodoTemporal == null) {
            throw new InvalidPositionException();
        }

        // Devolvemos el valor del nodo anterior.
        return nodoTemporal.anterior();
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        Dnodo<E> nodoTemporal = this.head;
        Dnodo<E> posicion = new Dnodo<E>(p.element());

        while (nodoTemporal != null && !nodoTemporal.equals(posicion)) {
            nodoTemporal.siguiente();
        }

        // si el nodoTemporal nos quedó nulo, entonces la posicion que nos dieron es invalida.
        if (nodoTemporal == null) {
            throw new InvalidPositionException();
        }

        // Ligamos los nodos "anterior" y "siguiente" al nuevo nodo, desligando el nodo que queremos borrar.
        nodoTemporal.anterior().establecerSiguiente(posicion);
        nodoTemporal.siguiente().establecerAnterior(posicion);
        
        this.size -= 1;

        return nodoTemporal.element();
    }

    @Override
    public E set(Position<E> p, E element) throws InvalidPositionException {
        Dnodo<E> nodoTemporal = this.head;
        Dnodo<E> posicion = new Dnodo<E>(p.element());

        while (nodoTemporal != null && !nodoTemporal.equals(posicion)) {
            nodoTemporal.siguiente();
        }

        // si el nodoTemporal nos quedó nulo, entonces la posicion que nos dieron es invalida.
        if (nodoTemporal == null) {
            throw new InvalidPositionException();
        }

        nodoTemporal.anterior().establecerSiguiente(posicion);
        nodoTemporal.siguiente().establecerAnterior(posicion);

        return posicion.element();
    }

    @Override
    public int size() {
        return this.size;
    }

    // Ejercicio 2
    // Debemos asignar e1 como segundo elemento de la lista.
    // Y e2 como el ante-ultimo elemento de la lista.
    public void ej2Modificar(E e1, E e2) throws ListaNoValida {
        // La unica exepcion que tenemos es en caso de que la lista tenga un único nodo, en este caso
        // es imposible satisfacer ambos requisitos
        if (this.size() == 1) {
            throw new ListaNoValida();
        }

        // Generamos ambos nodos
        Dnodo<E> nodo1 = new Dnodo<E>(e1);
        Dnodo<E> nodo2 = new Dnodo<E>(e2);
        
        if (this.isEmpty()) {
            this.head = nodo2;
            this.head.establecerSiguiente(nodo1);
            nodo1.establecerAnterior(this.head);
            // establecemos el enlace de head al nodo2, ya que es el último elemento.
            this.head.establecerAnterior(nodo1);
        } else {
            // Primero ubicamos al nodo que contiene a e1.
            // Si contamos con un segundo elemento, tenemos que ligarlo a nuestro nuevo nodo.
            if (this.head.siguiente() != null ) {
                nodo1.establecerSiguiente(this.head.siguiente());
                this.head.siguiente().establecerAnterior(nodo1);
            }
            // Ligamos head a nuestro nuevo nodo.
            this.head.establecerSiguiente(nodo1);
            nodo1.establecerAnterior(this.head);
            // Aumentamos el tamaño de la lista.
            this.size++;
            
            // Ahora ubicamos al nodo que contiene a e2.
            nodo2.establecerSiguiente(this.last());
            nodo2.establecerAnterior(this.last().anterior());
            this.last().anterior().establecerSiguiente(nodo2);
            this.last().establecerAnterior(nodo2);
        }
        this.size += 2;
    }

    // Ejercicio 3:
    public boolean ej3Buscar(Lista<E> lista, E e1) {
        IteradorDeListaDE<E> miIterador = new IteradorDeListaDE<E>(lista);

        
        while(miIterador.hasNext()) {
            if (miIterador.next().equals(e1)) {
                return true;
            }
        }

        return false;
    }

    // Ejercicio 4:
    public PositionList<E> ej4Repetir(Lista<E> lista) {
        // Generamos una nueva lista y el iterador de la lista que nos pasan por parametro.
        Lista<E> nuevaLista = new Lista<E>();
            
        for (E elemento: lista) {
            nuevaLista.addLast(elemento);
            nuevaLista.addLast(elemento);
        }

        return nuevaLista;
    }

  public E popHeadElement() throws EmptyListException {
    if (this.head != null) {
      E nodeToReturn = this.head.element();
      this.head = this.head.siguiente();
      return nodeToReturn;
    }
    throw new EmptyListException();
  }
}
