package practicos.practico5.hashdictionary;

import java.util.Iterator;

import practicos.practico4.Lista;

public class IteratorHashDictionary<T> implements Iterator<T> {
  protected Lista<T> lista; 
  protected int cantElementos;

  public IteratorHashDictionary(Lista<T> lista) {
    this.lista = lista;
    this.cantElementos = lista.size() - 1;
  }

  @Override
  public boolean hasNext() {
    return this.cantElementos > 0;
  }

  @Override
  public T next() {
    T result = null;
    if (this.hasNext()) {
      result = (T) this.lista.popHeadElement();
      this.cantElementos -= 1;
    }
    return result;
  }
}