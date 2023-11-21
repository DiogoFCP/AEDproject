package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

public class BSTKeyOrderIterator<K, V> implements Iterator<Entry<K,V>>{

    private BSTNode<K,V> root;

    public BSTKeyOrderIterator(BSTNode<K, V> root) {
        this.root = root;
    }

    public boolean hasNext() {
        return false;
    }

    public Entry<K,V> next() throws NoSuchElementException {
        return null;
    }

    public void rewind() {
        //TODO fazer o rewind
    }
}
