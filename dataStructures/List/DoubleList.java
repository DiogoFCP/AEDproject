package dataStructures.List;

import dataStructures.Iterator.Iterator;

public class DoubleList<E> implements List<E> {

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public E getFirst() throws EmptyListException {
        return null;
    }

    public E getLast() throws EmptyListException {
        return null;
    }

    public E get(int position) throws InvalidPositionException {
        return null;
    }

    public E removeFirst() throws EmptyListException {
        return null;
    }

    public E removeLast() throws EmptyListException {
        return null;
    }

    public E remove(int position) throws InvalidPositionException {
        return null;
    }

    public int find(E element) {
        return 0;
    }

    public boolean remove(E element) {
        return false;
    }
}
