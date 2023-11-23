package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

public class BSTKeyOrderIterator<K, V> implements Iterator<Entry<K,V>>{

    private BSTNode<K,V> root;
    private Stack<BSTNode<K,V>> stack;

    public BSTKeyOrderIterator(BSTNode<K, V> root) {
        stack = new StackInList<>();
        this.root = root;
        this.readLefts(this.root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Inserts in the stack the staring node and all the left
     * branches of the given node, until it find a null in the left.
     * @param node the starting node to add.
     */
    private void readLefts(BSTNode<K,V> node){
        do {
            stack.push(node);
            node = node.getLeft();
        } while (node != null);
    }

    public Entry<K,V> next() throws NoSuchElementException {

        if (!hasNext())
            throw new NoSuchElementException();

        BSTNode<K,V> toReturn = stack.pop();

        if (toReturn.getRight() != null)
            readLefts(toReturn.getRight());

        return toReturn.getEntry();
    }

    public void rewind() {
        stack = new StackInList<>();
        this.readLefts(this.root);
    }
}