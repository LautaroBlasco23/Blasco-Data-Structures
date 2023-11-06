package practicos.practico6;

import java.util.Iterator;

import practicos.practico4.Lista;
import practicos.practico4.interfaces.Position;
import practicos.practico4.interfaces.PositionList;
import practicos.practico6.interfaces.TreeTDA;
import practicos.practico6.exceptions.*;

public class Tree<E> implements TreeTDA<E> {
    private TNode<E> root;
    private int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(this.root);
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<TNode<E>> positions = new Lista<TNode<E>>();
        
        Iterator<E> currentTreeIterator = new TreeIterator<>(this.root);

        while (currentTreeIterator.hasNext()) {
            positions.addFirst(new TNode<E>(currentTreeIterator.next()));
        }

        return positions;
    }

    @Override
    public E replace(Position<E> v, E e) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'root'");
    }

    @Override
    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parent'");
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'children'");
    }

    @Override
    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInternal'");
    }

    @Override
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExternal'");
    }

    @Override
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRoot'");
    }

    @Override
    public void createRoot(E e) throws InvalidOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRoot'");
    }

    @Override
    public Position<E> addFirstChild(Position<E> p, E e) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFirstChild'");
    }

    @Override
    public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLastChild'");
    }

    @Override
    public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBefore'");
    }

    @Override
    public Position<E> addAfter(Position<E> p, Position<E> lb, E e) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }

    @Override
    public void removeExternalNode(Position<E> p) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeExternalNode'");
    }

    @Override
    public void removeInternalNode(Position<E> p) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeInternalNode'");
    }

    @Override
    public void removeNode(Position<E> p) throws InvalidPositionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeNode'");
    }
    
}