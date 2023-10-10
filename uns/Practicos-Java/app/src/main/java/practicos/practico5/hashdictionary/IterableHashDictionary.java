package practicos.practico5.hashdictionary;

import java.util.*;

import practicos.practico5.hashdictionary.IteratorHashDictionary;
import practicos.practico4.TDALista;

public class IterableHashDictionary<T> implements Iterable<T> {
  private TDALista<T> lista;
  private int elementos;

  // Constructor
  public IterableHashDictionary(TDALista<T> lista, int cantElementos) {
    this.lista = lista;
    this.elementos = cantElementos;
  }

  @Override
  public IteratorHashDictionary<T> iterator() {
    return new IteratorHashDictionary(this.lista);
  }
}

