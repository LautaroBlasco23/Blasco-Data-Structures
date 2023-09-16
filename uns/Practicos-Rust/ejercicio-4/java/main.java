import java.util.Stack;

class main {
    
    // Hecho sin usar implements Queue<T>
    public static class ColaConPila<T>{
        Stack<T> myStack;
        int max;
        int top;

        public ColaConPila(int max) {
            this.max = max;
            this.top = -1;
            this.myStack = new Stack<>();
        }


        // Métodos principales.
        public boolean add(T element) {
            if (this.top < this.max) {
                this.myStack.push(element);
                this.top++; 
                return true;
            }
            return false;
        }

        public T peek() {
            // devuelve el head de la cola, pero no lo elimina.
            return this.myStack.firstElement();
        }


        // devuelve y elimina el head de la cola, devuelve null, si la cola está vacía.
        public T poll() {
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
            this.top--;
            
            // Vuelvo a ingresar todos los elementos al stack.
            while (!stackTemporal.isEmpty()) {
                this.add(stackTemporal.pop());
            }

            return elemento;
        }

        // devuelve y elimina el head de la cola.
        public T remove() {
            // Misma lógica que el método poll. Pero sin devolver null. si el stack está vació saldrá una excepción.
            Stack<T> stackTemporal = new Stack<>();
            while (this.top > 0) {
                stackTemporal.push(this.myStack.pop());
                this.top--;
            }

            // Guardo el elemento para retornarlo más tarde.
            T elemento = this.myStack.pop();
            this.top--;
            
            // Vuelvo a ingresar todos los elementos al stack.
            while (!stackTemporal.isEmpty()) {
                this.add(stackTemporal.pop());
            }

            return elemento;
        }

    }
    
    public static void main(String[] args) {
        ColaConPila<Integer> queue = new ColaConPila<Integer>(5);

        // Ingresamos los numeros a la queue
        for (int i = 1; i < 6; i++) {
            System.out.println(i + " elemento que sale de la queue: " + queue.remove());
            queue.add(i);
        }

        // Los elementos deberían salir con el mismo orden con el que fueron ingresados.
        for (int i = 1; i < 6; i++) {
            System.out.println(i + " elemento que sale de la queue: " + queue.remove());
        }
    }
}