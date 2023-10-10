package practicos.practico5.map;

import java.util.*;

public class IterableMapeo<T> implements Iterable<T> {
  private T[] lista;
  private int elementos;

  // Constructor
  public IterableMapeo(T[] lista, int cantElementos) {
    this.lista = lista;
    this.elementos = cantElementos;
  }

  @Override
  public IteratorMapeo<T> iterator() {
    return new IteratorMapeo(this.lista, this.elementos);
  }
}
