package practicos.practico5.map;

import java.util.*;
import practicos.practico5.interfaces.TDAMap; 
import practicos.practico5.Entrada;
import practicos.practico5.exceptions.InvalidKeyException;
import practicos.practico4.Lista;
import practicos.practico4.DNodo.*;
import practicos.practico4.exceptions.InvalidPositionException;

public class Map<K, V> implements TDAMap<K, V> {
  private Lista<Entrada<K, V>> misEntradas;

  public Map() {
    this.misEntradas = new Lista<Entrada<K, V>>();
  }

  public int size() {
    return this.misEntradas.size();
  }

  public boolean isEmpty() {
    return this.misEntradas.size() == 0;
  }

  public V get(K key) throws InvalidKeyException {
    boolean encontre = false;
    V resultado = null; 
    Iterator<Entrada<K,V>> iterator = this.misEntradas.iterator();
    while (!encontre && iterator.hasNext()) {
      Entrada<K,V> entrada = iterator.next();
      if (entrada.getKey() == key) {
        resultado = entrada.getValue();
      }
    }
    if (resultado != null) {
      return resultado;
    }
    throw new InvalidKeyException();
  }

  public V put(K key, V value) throws InvalidKeyException {
    if (key == null) {
      throw new InvalidKeyException();
    }
    boolean encontre = false;
    V oldValue = null;
    
    for (Entrada<K,V> entrada: this.misEntradas) {
      if (entrada.getKey() == key) {
        encontre = true;
        oldValue = entrada.getValue();
        entrada.setValue(value);
        break;
      }
    }

    if (!encontre) {
      Entrada<K,V> nuevaEntrada = new Entrada<K,V>(key, value);
      this.misEntradas.addFirst(nuevaEntrada);
      return value;
    }

    return oldValue;
  }

  public V remove(K key) throws InvalidKeyException {
    for (Entrada<K,V> entrada: this.misEntradas) {
      if (entrada.getKey() == key) {
        Dnodo<Entrada<K,V>> position = new Dnodo<Entrada<K,V>>(entrada);
        try {
          this.misEntradas.remove(position);
        } catch (InvalidPositionException exception) {
          throw new InvalidKeyException();
        }
        return entrada.getValue();
      }
    }
    throw new InvalidKeyException();
  }

  public Iterable<K> keys() {
    Lista<K> nuevaLista = new Lista<K>();
    for (Entrada<K,V> entrada: this.misEntradas) {
      nuevaLista.addFirst(entrada.getKey());
    }
    return nuevaLista;
  }

  public Iterable<V> values() {
    Lista<V> nuevaLista = new Lista<V>();
    for (Entrada<K,V> entrada: this.misEntradas) {
      nuevaLista.addFirst(entrada.getValue());
    }
    return nuevaLista;
  }

  public Iterable<Entrada<K,V>> entries() {
    Iterator<Entrada<K,V>> iterator = this.misEntradas.iterator();
    Lista<Entrada<K,V>> nuevaLista = new Lista<Entrada<K,V>>();
    while (iterator.hasNext()) {
      nuevaLista.addFirst(iterator.next());
    }
    return nuevaLista;
  }
}