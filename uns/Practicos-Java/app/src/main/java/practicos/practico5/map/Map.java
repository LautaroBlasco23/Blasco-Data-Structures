package practicos.practico5;

import practicos.practico5.interfaces.TDAMap; 
import practicos.practico5.interfaces.TDAEntry;
import practicos.practico5.Entrada;
import practicos.practico5.exceptions.InvalidKeyException;
import java.util.*;
import practicos.practico5.map.IterableMapeo;

public class Map<K, V> implements TDAMap<K, V> {
  // size equivale a la cant de elementos que tengo.
  private int size;
  private Entrada<K, V>[] misEntradas;

  public Map(int max) {
    this.misEntradas = new Entrada[max];
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public V get(K key) throws InvalidKeyException {
    boolean encontre = false;
    V resultado = null; 
    for (int i = 0; i < this.size && !encontre; i++) {
      if (this.misEntradas[i] != null) {
        if (this.misEntradas[i].getKey() == key) {
          resultado = this.misEntradas[i].getValue();
          encontre = true;
        }
      }
    }

    if (resultado != null) {
      return resultado;
    }
    throw new InvalidKeyException();
  }

  public V put(K key, V value) throws InvalidKeyException {
    boolean encontre = false;
    V resultado = null; 
    for (int i = 0; i < this.size && !encontre; i++) {
      if (this.misEntradas[i] != null) {
        if (this.misEntradas[i].getKey() == key) {
          resultado = this.misEntradas[i].getValue();
          // establecemos el nuevo valor.
          this.misEntradas[i].setValue(value);
          encontre = true;
        }
      }
    }

    if (resultado != null) {
      return resultado;
    }
    throw new InvalidKeyException();
  }

  public V remove(K key) throws InvalidKeyException {
  boolean encontre = false;
    V resultado = null; 
    for (int i = 0; i < this.size && !encontre; i++) {
      if (this.misEntradas[i] != null) {
        if (this.misEntradas[i].getKey() == key) {
          resultado = this.misEntradas[i].getValue();
          // establecemos el nuevo valor.
          this.misEntradas[i] = this.misEntradas[this.size-1];
          this.misEntradas[this.size-1].setValue(null);
          encontre = true;
        }
      }
    }

    if (resultado != null) {
      return resultado;
    }
    throw new InvalidKeyException();
  }

  public Iterable<K> keys() {
    K[] listaKeys = (K[]) new Object[this.size];
    for (int i = 0; i < this.size(); i++) {
      listaKeys[i] = this.misEntradas[i].getKey();
    }
    return new IterableMapeo(listaKeys, this.size);
  }

  public Iterable<V> values() {
    V[] listaValues = (V[]) new Object[this.size];
    for (int i = 0; i < this.size(); i++) {
      listaValues[i] = this.misEntradas[i].getValue();
    }
    return new IterableMapeo(listaValues, this.size);
  }

  public Iterable<TDAEntry<K,V>> entries() {
    TDAEntry<K,V>[] listaEntrys = (TDAEntry<K,V>[]) new Object[this.size];
    for (int i = 0; i < this.size(); i++) {
      listaEntrys[i] = this.misEntradas[i];
    }
    return new IterableMapeo(listaEntrys, this.size);
  }
}
