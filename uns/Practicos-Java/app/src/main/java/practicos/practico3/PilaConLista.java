package practicos.practico3;

import java.util.ArrayList;
import java.util.EmptyStackException;

import practicos.practico3.interfaces.Stack;

// No puedo importar el stack porque ya hay otra clase de nombre 'Stack' siendo importada.
public class PilaConLista<E> implements Stack<E> {
    private ArrayList<E> miLista;

    public PilaConLista() {
        this.miLista = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return miLista.size() == 0;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (this.miLista.isEmpty()) {
            throw new EmptyStackException();
        }
        return miLista.remove(miLista.size() - 1);
    }

    @Override
    public void push(E element) {
        this.miLista.add(this.miLista.size(), element);;            
    }

    @Override
    public int size() {
        return this.miLista.size();
    }

    @Override
    public E top() throws EmptyStackException {
        if (this.miLista.isEmpty()) {
            throw new EmptyStackException();
        }
        return miLista.get(miLista.size() - 1);
    }
}