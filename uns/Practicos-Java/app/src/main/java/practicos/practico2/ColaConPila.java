package practicos.practico2;

import java.util.EmptyStackException;
import java.util.Stack;

import practicos.practico2.EmptyQueueException.EmptyQueueException;
import practicos.practico2.interfaces.Queue;

// Ejercicio 4:
// Implementando la clase Queue generada por la catedra.
public class ColaConPila<T> implements Queue<T>{

    Stack<T> myStack;
    int max;
    int top;

    public ColaConPila() {
        this.top = -1;
        this.myStack = new Stack<>();
    }


    @Override
    public void enqueue(T element) {
        this.myStack.push(element);
        this.top++;
    }

    // devuelve y elimina el head de la cola.
    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.top == -1) {
            throw new EmptyQueueException();
        } else {
            Stack<T> aux = new Stack<>();
            while (!this.myStack.isEmpty()) {
                aux.push(this.myStack.pop());
            }
            T elementoRetorno = aux.pop();
            while (!aux.isEmpty()) {
                this.myStack.push(aux.pop());
            }
            this.top--;
            return elementoRetorno;
        }
    }

    // devuelve y elimina el head de la cola, devuelve null, si la cola está vacía.
    public T front() {
        if (this.top == -1) {
            return null;
        }
        
        // Creo un stack temporal, para guardar todos los elementos que están "arriba" del head de la cola.
        Stack<T> stackTemporal = new Stack<>();
        while (this.top > 0) {
            stackTemporal.push(this.myStack.pop());
            this.top--;
        }

        // Guardo el elemento para retornarlo más tarde.
        T elemento = this.myStack.pop();
        this.myStack.push(elemento);

        
        // Vuelvo a ingresar todos los elementos al stack.
        while (!stackTemporal.isEmpty()) {
            this.myStack.push(stackTemporal.pop());
            this.top++;
        }

        return elemento;
    }

    public T peek() throws EmptyQueueException{
        // devuelve el head de la cola, pero no lo elimina.
        if (this.top == -1) {
            throw new EmptyQueueException();
        }
        return this.myStack.firstElement();
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public int size() {
        return this.top + 1;
    }
}
