package practicos.practico6;

import practicos.practico4.Lista;
import practicos.practico4.interfaces.PositionList;
import practicos.practico4.interfaces.Position;

public class TNode<E> implements Position<E> {

	protected E rotulo;
	protected PositionList<TNode<E>> hijos;
	
	public TNode( E rotulo ) {
		this.rotulo = rotulo;
		this.hijos = new Lista<TNode<E>>();
	}

	public TNode( E rotulo, PositionList<TNode<E>> hijos) {
		this.rotulo = rotulo;
		this.hijos = hijos;
	}
	
	public PositionList<TNode<E>> getHijos() {
		return this.hijos;
	}
	
	@Override
	public E element() {
		return this.rotulo;
	}
	
	public void setElement( E e ) {
		this.rotulo = e;
	}
	
	public void setHijos(PositionList<TNode<E>> hijos ) {
		this.hijos = hijos;
	}

}
