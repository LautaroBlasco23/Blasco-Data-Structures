import java.util.Stack;

class main {
    // Declaramos la clase Persona con el método "obtenerNombre" para ver si hicimos bien el ejercicio.
    public static class Persona {
        private String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String obtenerNombre() {
            return this.nombre;
        }
    }
    
    public static void Invertir(Persona[] arreglo) {
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

    public static void main(String[] args) {
        // Generamos el arreglo de personas.
        Persona[] miArregloDePersonas = new Persona[5];

        miArregloDePersonas[0] = new Persona("Lautaro");
        miArregloDePersonas[1] = new Persona("Tomas");
        miArregloDePersonas[2] = new Persona("Agustin");
        miArregloDePersonas[3] = new Persona("Jorge");
        miArregloDePersonas[4] = new Persona("Roman");

        // Mostramos por consola el orden actual del arreglo.
        for(int i = 0; i < 5; i++) {
            System.out.println(miArregloDePersonas[i].obtenerNombre());
        }

        // Invertimos el arreglo.
        Invertir(miArregloDePersonas);
        System.out.println();
        
        // Mostramos por consola el nuevo orden del arreglo.
        for(int i = 0; i < 5; i++) {
            System.out.println(miArregloDePersonas[i].obtenerNombre());
        }

    }
}