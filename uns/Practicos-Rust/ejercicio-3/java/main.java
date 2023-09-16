import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static Queue devolverProducto(Queue cola1, Queue cola2) {
        
        Queue colaRetorno = new ArrayDeque<>();
        
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

    public static void main(String[] args) {
        Queue<Integer> cola1 = new LinkedList<Integer>(); 
        Queue<String> cola2 = new ArrayDeque<String>(); 

        // Agrego manualmente elementos a cola1.
        cola1.add(1);
        cola1.add(2);
        cola1.add(3);
        cola1.add(4);
        cola1.add(5);
        cola1.add(6);
        cola1.add(7);

        // Agrego manualmente elementos a cola2.
        cola2.add("A");
        cola2.add("B");
        cola2.add("C");
        cola2.add("D");



        // Testeos y muestras por consola.
        System.out.println("Cola1:");
        for (int n : cola1) {
            System.out.print(n + " ");
        }

        System.out.println("");
        System.out.println("Cola2:");
        for (String s : cola2) {
            System.out.print(s + " ");
        }

        Queue colaResultado = devolverProducto(cola1, cola2);
        System.out.println("");
        System.out.println("cola resultado:");
        while(!colaResultado.isEmpty()) {
            System.out.print(colaResultado.remove() + " ");
        }


    }
}
