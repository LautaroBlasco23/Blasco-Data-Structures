package practicos.practico5.hashdictionary;

import practicos.practico4.Lista;
import practicos.practico4.DNodo.Dnodo;
import practicos.practico5.exceptions.InvalidKeyException;
import practicos.practico5.Entrada;
import practicos.practico5.dictionary.Dictionary;
import practicos.practico5.exceptions.InvalidEntryException;
import java.util.Iterator;

public class HashDictionary<K,V> extends Dictionary<K,V> {
  protected Lista<Entrada<K,V>>[] hashTable;

  public HashDictionary() {
    // We will contain 10 buckets by default.
    this.hashTable = new Lista[10];
    for (int i = 0; i < 10; i++) {
      // Initialize TDAListas in every bucket.
      this.hashTable[i] = new Lista<Entrada<K,V>>();
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

  public Entrada<K,V> find(K key) throws InvalidKeyException {
    Entrada<K,V> entradaRetorno = null;
    if (key == null) {
      throw new InvalidKeyException();
    }
    for (int i = 0; i < this.hashTable.length; i++) {
      Iterator<Entrada<K,V>> iterador = this.hashTable[i].iterator();
      while (iterador.hasNext()) {
        Entrada<K,V> entrada = iterador.next();
        if (entrada.getKey() == key) {
          entradaRetorno = entrada;
        }
      }
    }
    return entradaRetorno;
}


  public Iterable<Entrada<K,V>> findAll(K key) throws InvalidKeyException {
    try {
      int hashNumber = this.hash(key);
      Iterator<Entrada<K,V>> iterator = this.hashTable[hashNumber].iterator();
      Lista<Entrada<K,V>> listaResultados = new Lista<Entrada<K,V>>();

      while (iterator.hasNext()) {
        Entrada<K,V> entry = iterator.next();
        System.out.println(entry);
        System.out.println(key);
        if (entry.getKey() == key) {
          listaResultados.addFirst(entry);
        }
      }
      System.out.println(listaResultados);
      return listaResultados;
    } catch (Exception e) {
      throw new InvalidKeyException();
    }
  }

  public Entrada<K,V> insert(K key, V value) throws InvalidKeyException {
    if (key == null) {
      throw new InvalidKeyException();
    }

    int hashNumber = this.hash(key);
    Entrada<K,V> nuevaEntrada = new Entrada<K,V>(key, value);
    this.hashTable[hashNumber].addFirst(nuevaEntrada);

    return nuevaEntrada;
  }

  public Entrada<K,V> remove(Entrada<K,V> e) throws InvalidEntryException {
    if (e == null || e.getKey() == null) {
      throw new InvalidEntryException();
    }

    int hashNumber = this.hash(e.getKey());
    // Creamos un nodo doblemente enlazado, el cual posteriormente usaremos como posición.
    Dnodo<Entrada<K,V>> pos = new Dnodo<Entrada<K,V>>(e);
    try {
      this.hashTable[hashNumber].remove(pos);
      return e;
    } catch (Exception exc) {
      throw new InvalidEntryException();
    }
  }

  public Iterable<Entrada<K,V>> entries() {
    Lista<Entrada<K,V>> lista = new Lista<Entrada<K,V>>();
    for (int i = 0; i < 10; i++) {
      Iterator<Entrada<K,V>> iterador = this.hashTable[i].iterator();
      while (iterador.hasNext()) {
        lista.addFirst(iterador.next());
      }
    }
    return lista;
  }
}
