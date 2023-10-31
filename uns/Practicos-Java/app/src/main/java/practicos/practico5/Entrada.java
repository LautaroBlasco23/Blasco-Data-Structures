package practicos.practico5;

import practicos.practico5.interfaces.TDAEntry;

public class Entrada<K, V> implements TDAEntry<K,V> {
  private K clave;
  private V valor;

  public Entrada(K clave, V valor) {
    this.clave = clave;
    this.valor = valor;
  }

  public K getKey() {
    return this.clave;
  }

  public V getValue() {
    return this.valor;
  }

  public void setKey(K clave) {
    this.clave = clave;
  }

  public void setValue(V valor) {
    this.valor = valor;
  }

  public String toString() {
    return "(" + this.getKey() + "," + this.getValue() + ")";
  }
}