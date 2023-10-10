package practicos.practico5.hashdictionary;

import practicos.practico4.TDALista;
import practicos.practico4.DNodo.Dnodo;
import practicos.practico4.exceptions.InvalidPositionException;
import practicos.practico5.hashdictionary.IterableHashDictionary;
import practicos.practico4.interfaces.IterableDeListaDE;
import practicos.practico4.interfaces.IteradorDeListaDE;
import practicos.practico5.exceptions.InvalidKeyException;
import practicos.practico5.Entrada;
import practicos.practico5.dictionary.Dictionary;
import practicos.practico5.exceptions.InvalidEntryException;
import practicos.practico5.interfaces.TDAEntry;
import java.util.Iterator;

public class HashDictionary<K,V> extends Dictionary<K,V> {
  protected TDALista[] hashTable;

  public HashDictionary() {
    // We will contain 10 buckets by default.
    this.hashTable = new TDALista[10];
    for (int i = 0; i < 10; i++) {
      // Initialize TDAListas in every bucket.
      this.hashTable[i] = new TDALista<TDAEntry<K,V>>(null);
    }
  }

  public int hash(K key) {
    return (key.hashCode() % 10);
  }

  public int size() {
    int sum = 0;
    for (int i = 0; i < this.hashTable.length; i++) {
      sum += this.hashTable[i].size();
    }

    return sum;
  }

  public boolean isEmpty() {
    int sum = 0;
    for (int i = 0; i < this.hashTable.length; i++) {
      sum += this.hashTable[i].size();
    }

    return sum == 0;
  }

  public TDAEntry<K,V> find(K key) throws InvalidKeyException {
    for (int i = 0; i < this.hashTable.length; i++) {
      Iterator<TDAEntry<K,V>> iterador = this.hashTable[i].iterator();
      while (iterador.hasNext()) {
        TDAEntry<K,V> value = iterador.next();
        if (value.getKey() == key) {
          return value;
        }
      }
    }
    throw new InvalidKeyException();
  }


  public Iterable findAll(K key) throws InvalidKeyException {
    int hashNumber = this.hash(key);
    Iterator<TDAEntry<K,V>> iterator = this.hashTable[hashNumber].iterator();
    TDALista<TDAEntry<K,V>> listaResultados = new TDALista<TDAEntry<K,V>>(null);

    while (iterator.hasNext()) {
      TDAEntry<K,V> entry = iterator.next();
      if (entry.getKey() == key) {
        listaResultados.addLast(entry);
      }
    }
    return new IterableDeListaDE<TDAEntry<K,V>>(listaResultados);
  }

  public TDAEntry<K,V> insert(K key, V value) throws InvalidKeyException {
    int hashNumber = this.hash(key);
    TDAEntry<K,V> nuevaEntrada = new Entrada<>(key, value);
    this.hashTable[hashNumber].addLast(nuevaEntrada);

    return nuevaEntrada;
  }

  public TDAEntry<K,V> remove(TDAEntry<K,V> e) throws InvalidEntryException {
    int hashNumber = this.hash(e.getKey());
    Dnodo<TDAEntry<K,V>> pos = new Dnodo<TDAEntry<K,V>>(e);
    try {
      this.hashTable[hashNumber].remove(pos);
      return e;
    } catch (InvalidPositionException exc) {
      System.out.println(exc);
      throw new InvalidEntryException();
    }
  }

  public Iterable<TDAEntry<K,V>> entries() {
    TDALista<TDAEntry<K,V>> lista = new TDALista<TDAEntry<K,V>>(null);
    for (int i = 0; i < 10; i++) {
      IteradorDeListaDE<TDAEntry<K,V>> iterador = new IteradorDeListaDE<>(this.hashTable[i]);
      while (iterador.hasNext()) {
        lista.addFirst(iterador.next());
      }
    }
    return new IterableDeListaDE<TDAEntry<K,V>>(lista);
  }
}
