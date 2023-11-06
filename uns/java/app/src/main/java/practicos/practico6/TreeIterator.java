package practicos.practico6;

import java.util.Iterator;

import practicos.practico4.interfaces.PositionList;

public class TreeIterator<E> implements Iterator<E>  {
    private TNode<E> currentNode;
    private PositionList<TNode<E>> remainingNodes;

    public TreeIterator(TNode<E> nodo) {
        this.currentNode = nodo;
        this.remainingNodes = nodo.getHijos();
    }

    public boolean hasNext() {
        return (this.currentNode == null);
    }

    public E next() {
        try {
            E element = this.currentNode.element();
            
            PositionList<TNode<E>> sons = this.currentNode.getHijos();
            while (!sons.isEmpty()) {
                this.remainingNodes.addLast(sons.remove(sons.first()));
            }
            this.currentNode = this.remainingNodes.remove(this.remainingNodes.first());
            
            return element;
        } catch (Exception e) {
            System.out.println("TreeIterator exception handled");
            return null;
        }
    }   
}
