package practicos.practico5.dictionary;

import practicos.practico4.TDALista;
import practicos.practico4.DNodo.Dnodo;
import practicos.practico4.exceptions.InvalidPositionException;
import practicos.practico4.interfaces.IteradorDeListaDE;
import practicos.practico5.dictionary.IterableDictionary;
import practicos.practico5.interfaces.TDADictionary;
import practicos.practico5.interfaces.TDAEntry;
import practicos.practico5.exceptions.*;
import practicos.practico5.Entrada;
import java.util.*;

public class Dictionary<K,V> implements TDADictionary<K, V> {
  protected TDALista<TDAEntry<K,V>> misEntradas;

  public Dictionary() {
    this.misEntradas = new TDALista<TDAEntry<K,V>>(null);
  }
  
	public int size() {
    return this.misEntradas.size();
  }
	
	public boolean isEmpty() {
    return this.misEntradas.size() == 0;
  }
	
	public TDAEntry<K,V> find(K key) throws InvalidKeyException {
    IteradorDeListaDE<TDAEntry<K,V>> iterador = new IteradorDeListaDE<TDAEntry<K,V>>(this.misEntradas);

    while (iterador.hasNext()) {
      TDAEntry<K,V> elemento = iterador.next();
      if (elemento.getKey() == key) {
        return elemento;
      }
    }

    throw new InvalidKeyException();
  }
	
	public Iterable<TDAEntry<K,V>> findAll(K key) throws InvalidKeyException {
    IterableDictionary<TDAEntry<K,V>> iterador = new IterableDictionary<TDAEntry<K,V>>(this.misEntradas, this.misEntradas.size());
    return iterador;
  }
	
	public TDAEntry<K,V> insert(K key, V value) throws InvalidKeyException {
    Entrada<K,V> nuevaEntrada = new Entrada<>(key, value);
    this.misEntradas.addLast(nuevaEntrada);
    return nuevaEntrada;
  }
	
	public TDAEntry<K,V> remove(TDAEntry<K,V> e) throws InvalidEntryException {
    Dnodo<TDAEntry<K,V>> position = new Dnodo(e);
    try {
      this.misEntradas.remove(position);
      return e;
    } catch (InvalidPositionException exception) {
      throw new InvalidEntryException();
    }
  }
	
	public Iterable<TDAEntry<K,V>> entries() {
    return new IterableDictionary(this.misEntradas, this.misEntradas.size());
  }

}
