package practicos.practico5.hashdictionary;

import java.util.Iterator;

import com.google.common.collect.Multiset.Entry;

import practicos.practico4.TDALista;

public class IteratorHashDictionary<T> implements Iterator<T> {
  protected TDALista lista; 
  protected int elementos;

  public IteratorHashDictionary(TDALista<T> lista) {
    this.lista = lista;
    this.elementos = lista.size() - 1;
  }

  @Override
  public boolean hasNext() {
    return this.elementos > 0;
  }

  @Override
  public T next() {
    T result = null;
    if (this.hasNext()) {
      result = (T) this.lista.popHeadElement();
    }
    return result;
  }
}


