import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class main {
    public static void soloImpares(Queue<Integer> cola) {
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


    public static void main(String[] args) {
        // Genero la Cola usando la estructura ArrayDeque dada por java.
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        // agrego valores a la cola para probar mi funcion.
        for (int i = 1; i < 50; i += 3) {
            myQueue.add(i);
        }

        // Muestro en consola la Queue, aplico la función "soloImpares" y 
        // muestro el resultado por consola.
        System.out.println("Queue Completa:");
        for(int s : myQueue) { 
            System.out.println(s); 
        }
        
        soloImpares(myQueue);
        System.out.println("");
        System.out.println("Ahora solo los impares:");


        for(int s : myQueue) { 
            System.out.println(s); 
        }
    }

}