package practicos;

import practicos.practico2.ColaConPila;
import practicos.practico2.EjerciciosTP2;
import practicos.practico2.EmptyQueueException.EmptyQueueException;
import practicos.practico2.Persona.Persona;

public class App {
    public static void main(String[] args) {
        // Generamos el arreglo de personas.

        ColaConPila c = new ColaConPila();

        c.enqueue("Hola que tal mi amor");
        c.enqueue("que calor pues");
        c.enqueue("Hola");
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.front());
        System.out.println(c.dequeue());
        System.out.println(c.front());



    }
}