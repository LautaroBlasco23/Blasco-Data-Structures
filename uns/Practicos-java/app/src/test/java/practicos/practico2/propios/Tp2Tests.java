package practicos.practico2.propios;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import practicos.practico2.EjerciciosTP2;
import practicos.practico2.Persona.Persona;

public class Tp2Tests {
    private EjerciciosTP2 tester;

    @Before
    public void setUp() {
        this.tester = new EjerciciosTP2();
    }

    // Test de ejercicio 1.
    @Test public void ej1Invertir() {
        // Generamos el arreglo de personas.
        Persona[] miArregloDePersonas = new Persona[5];
        Persona[] arregloInvertido = new Persona[5];

        // Creamos el arreglo para invertir
        miArregloDePersonas[0] = new Persona("Lautaro");
        miArregloDePersonas[1] = new Persona("Tomas");
        miArregloDePersonas[2] = new Persona("Agustin");
        miArregloDePersonas[3] = new Persona("Jorge");
        miArregloDePersonas[4] = new Persona("Roman");

        // Creamos un arreglo con los valores invertidos.
        arregloInvertido[0] = new Persona("Roman");
        arregloInvertido[1] = new Persona("Jorge");
        arregloInvertido[2] = new Persona("Agustin");
        arregloInvertido[3] = new Persona("Tomas");
        arregloInvertido[4] = new Persona("Lautaro");

        // Invertimos el arreglo original
        tester.ej1Invertir(miArregloDePersonas);
        

    }

    // Test de Ejercicio 2:
    @Test public void ej2SsoloImpares() {
        // Genero la Cola usando la estructura ArrayDeque dada por java.
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        // agrego valores a la cola para probar mi funcion.
        for (int i = 1; i < 50; i += 3) {
            myQueue.add(i);
        }

        tester.ej2SsoloImpares(myQueue);
    }

    // Tester Ejercicio 3:
    @Test public void ej3DevolverProducto() {
        Queue<Integer> cola1 = new LinkedList<Integer>(); 
        Queue<String> cola2 = new ArrayDeque<String>(); 

        // Agrego elementos a cola1.
        for (int i = 1; i < 8; i++) {
            cola1.add(i);
        }

        // Agrego manualmente elementos a cola2.
        cola2.add("A");
        cola2.add("B");
        cola2.add("C");
        cola2.add("D");

        // Testeos y muestras por consola.
        for (int n : cola1) {
            System.out.print(n + " ");
        }

        for (String s : cola2) {
            System.out.print(s + " ");
        }

    }
}