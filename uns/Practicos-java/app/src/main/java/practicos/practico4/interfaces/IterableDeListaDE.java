package practicos.practico4.interfaces;

import practicos.practico4.TDALista;

public class IterableDeListaDE<E> implements Iterable<E> {
    private TDALista<E> lista;

    public IterableDeListaDE(TDALista<E> lista) {
        this.lista = lista;
    }

    @Override
    public IteradorDeListaDE<E> iterator() {
        return new IteradorDeListaDE<>(this.lista);
    }   
}