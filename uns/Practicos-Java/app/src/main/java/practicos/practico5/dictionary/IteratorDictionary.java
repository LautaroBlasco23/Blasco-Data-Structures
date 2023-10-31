package practicos.practico5.dictionary;

import java.util.Iterator;

import practicos.practico4.Lista;

public class IteratorDictionary<T> implements Iterator<T> {
  protected Lista<T> lista;
  protected int elementos;

  public IteratorDictionary(Lista<T> listaEntradas, int elementos) {
    this.lista = listaEntradas;
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
      result = this.lista.popHeadElement();
    }
    return result;
  }
}
