package practicos.practico2;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;
    
// La Clase persona es una clase hiper básica desarrollada para poder desarrollar el ejercicio 1.
import practicos.practico2.Persona.Persona;

public class EjerciciosTP2<E> {
    // Ejercicio 1:
    // Invertir un arreglo de personas usando un Stack.
    public void ej1Invertir(Persona[] arreglo) {
        Stack<Persona> miPila = new Stack<>();

        // Ingresamos valores a la pila.
        for(int i = 0; i < 5; i++) {
            miPila.push(arreglo[i]);
        }

        // Devolvemos valores al arreglo.
        for(int i = 0; i < 5; i++) {
        arreglo[i] = miPila.pop();
        }
    }

    // Ejercicio 2:
    // Filtrar una Queue y dejar únicamente los valores impares de la misma.
    public void ej2SsoloImpares(Queue<Integer> cola) {
        // Creamos una cola temporal, donde guardaremos los valores impares.
        Queue<Integer> nuevaCola = new ArrayDeque<Integer>();
        while(!cola.isEmpty()) {

            // Comparamos el primer elemento de la cola, y en caso de ser impar, 
            // lo agregamos a nuestra cola temporal.
            int numeroAComparar = cola.remove();
            if((numeroAComparar % 2) == 1) {
                nuevaCola.add(numeroAComparar);
            }

        }
        
        // Volvemos a ingresar todos los valores impares a la cola original.
        while(!nuevaCola.isEmpty()) {
            cola.add(nuevaCola.remove());
        }
    }

    // Ejercicio 3:
    public Queue<E> ej3DevolverProducto(Queue<E> cola1, Queue<E> cola2) {    
        Queue<E> colaRetorno = new ArrayDeque<>();        
        boolean hayElementos = !cola1.isEmpty() || !cola2.isEmpty();

        while (hayElementos) {
            if (!cola1.isEmpty()) {
                colaRetorno.add(cola1.remove());
            }

            if (!cola2.isEmpty()) {
                colaRetorno.add(cola2.remove());
            }
            hayElementos = !cola1.isEmpty() || !cola2.isEmpty();
        } 
        return colaRetorno;
    }
    
}