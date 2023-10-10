package practicos.practico5.dictionary;

import java.util.*;

import practicos.practico4.TDALista;

public class IterableDictionary<T> implements Iterable<T> {
  private TDALista<T> lista;
  private int elementos;

  // Constructor
  public IterableDictionary(TDALista<T> lista, int cantElementos) {
    this.lista = lista;
    this.elementos = cantElementos;
  }

  @Override
  public IteratorDictionary<T> iterator() {
    return new IteratorDictionary(this.lista, this.elementos);
  }
}
