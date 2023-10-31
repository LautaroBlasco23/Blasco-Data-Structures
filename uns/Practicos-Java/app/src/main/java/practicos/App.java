package practicos;

import practicos.practico4.Lista;

public class App {
  public static void main(String[] args) {
	  System.out.println("Nothing trully important");

    Lista<Integer> ejerciciosInt = new Lista<>();
    Lista<Integer> l = new Lista<Integer>();
    l.addLast(1);
    l.addLast(3);
    l.addLast(5);
    l.addLast(7);
    System.out.println(l.isEmpty());
    System.out.println(ejerciciosInt.ej3Buscar(l, 3));
    System.out.println(ejerciciosInt.ej3Buscar(l, 7));
    System.out.println(ejerciciosInt.ej3Buscar(l, 4));
  }
}