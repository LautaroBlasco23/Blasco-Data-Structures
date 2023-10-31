package practicos.practico5.map;

import java.util.Iterator;

public class IteratorMapeo<T> implements Iterator<T> {
  protected T[] lista;
  protected int elementos;

  public IteratorMapeo(T[] listaEntradas, int elementos) {
    for (int i = 0; i < elementos; i++) {
      this.lista[i] = listaEntradas[i];
    }
    this.elementos = elementos;
  }

  @Override
  public boolean hasNext() {
    return this.elementos > 0;
  }

  @Override
  public T next() {
    T result = null;
    if (this.hasNext()) {
      result = this.lista[--this.elementos];
    }
    return result;
  }
}
