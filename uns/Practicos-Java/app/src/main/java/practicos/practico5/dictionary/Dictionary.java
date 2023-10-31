package practicos.practico5.dictionary;

import practicos.practico4.Lista;
import practicos.practico4.DNodo.Dnodo;
import practicos.practico4.exceptions.InvalidPositionException;
import practicos.practico4.interfaces.IteradorDeListaDE;
import practicos.practico5.interfaces.TDADictionary;
import practicos.practico5.exceptions.*;
import practicos.practico5.Entrada;

public class Dictionary<K,V> implements TDADictionary<K, V> {
  protected Lista<Entrada<K,V>> misEntradas;

  public Dictionary() {
    this.misEntradas = new Lista<Entrada<K,V>>();
  }
  
	public int size() {
    return this.misEntradas.size();
  }
	
	public boolean isEmpty() {
    return this.misEntradas.size() == 0;
  }
	
	public Entrada<K,V> find(K key) throws InvalidKeyException {
    if (key == null) {
      throw new InvalidKeyException();
    }

    Entrada<K,V> elemento = null;

    IteradorDeListaDE<Entrada<K,V>> iterador = new IteradorDeListaDE<Entrada<K,V>>(this.misEntradas);

    while (iterador.hasNext()) {
      elemento = iterador.next();
      if (elemento.getKey() == key) {
        return elemento;
      }
    }

    return elemento;
  }
	
	public Iterable<Entrada<K,V>> findAll(K key) throws InvalidKeyException {
    if (key == null) {
      throw new InvalidKeyException();
    }

    Lista<Entrada<K,V>> coincidencias = new Lista<Entrada<K,V>>();

    for (Entrada<K,V> entrada: this.misEntradas) {
      if (entrada.getKey() == key) {
        coincidencias.addLast(entrada);
      }
    }
    return coincidencias;
  }
	
	public Entrada<K,V> insert(K key, V value) throws InvalidKeyException {
    if (key == null) {
      throw new InvalidKeyException();
    }

    Entrada<K,V> nuevaEntrada = new Entrada<>(key, value);
    this.misEntradas.addFirst(nuevaEntrada);
    return nuevaEntrada;
  }
	
	public Entrada<K,V> remove(Entrada<K,V> e) throws InvalidEntryException {
    if (e == null) {
      throw new InvalidEntryException();
    }

    Dnodo<Entrada<K,V>> position = new Dnodo<Entrada<K,V>>(e);
    try {
      this.misEntradas.remove(position);
      return e;
    } catch (InvalidPositionException exception) {
      throw new InvalidEntryException();
    }
  }
	
	public Iterable<Entrada<K,V>> entries() {
    return this.misEntradas;
  }
}
