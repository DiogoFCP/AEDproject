package dataStructures.List;

import dataStructures.Iterator.Iterator;

public class DoubleList<E> implements List<E> {

    /**
     * Nested class that represents each node used in this double list.
     * @param <E> the type of element the node will hold.
     */
    static class DoubleListNode<E> {

        // Element stored in the node.
        private E element;

        // Pointer to the next node.
        private DoubleListNode<E> next;

        // Pointer to the previous node.
        private DoubleListNode<E> previous;

        /**
         * Constructor that stores an element on the node and assigns a next and previous node to this node.
         * @param nodeElement the element being stored in the node.
         * @param nextNode the node in front of this node.
         * @param previousNode the node behind this node.
         */
        public DoubleListNode(E nodeElement, DoubleListNode<E> nextNode, DoubleListNode<E> previousNode){
            element = nodeElement;
            next = nextNode;
            previous = previousNode;
        }

        /**
         * Constructor that only stores the element in the node and does not assign the next and previous nodes.
         * @param nodeElement the element being stored in the node.
         */
        public DoubleListNode(E nodeElement){
            element = nodeElement;
            next = null;
            previous = null;
        }

        public E getElement() { return element; }

        public DoubleListNode<E> getNext() { return next; }

        public DoubleListNode<E> getPrevious() { return previous; }

        public void setElement(E newElement) { element = newElement; }

        public void setNext( DoubleListNode<E> newNext ) { next = newNext; }

        public void setPrevious( DoubleListNode<E> newPrevious) { previous = newPrevious; }
    }

    // The first node in the list.
    protected DoubleListNode<E> head;

    // The last node in the list.
    protected DoubleListNode<E> tail;

    // The current size of the list.
    protected int currentSize;

    /**
     * Creates an empty Double List with no head or tail and with the current size at 0.
     */
    public DoubleList(){
        head = null;
        tail = null;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    // TODO
    public Iterator<E> iterator() {
        return null;
    }

    public E getFirst() throws EmptyListException {
        if( this.isEmpty() )
            throw new EmptyListException();
        return head.getElement();
    }

    public E getLast() throws EmptyListException {
        if( this.isEmpty() )
            throw new EmptyListException();
        return tail.getElement();
    }

    /**
     * Gets the node with the given position, if the position is closer to the head it starts searching
     * from the head, if it is closer to the tail it starts on the tail.
     * Requires that the position is valid ( from 0 to currentSize-1 ).
     * @param position position of the node we are looking for.
     * @return the node on the given position.
     */
    protected DoubleListNode<E> getNode( int position ) {
        DoubleListNode<E> node;
        if( position <= (currentSize - 1) / 2) {
            node = head;
            for(int i = 0; i < position; i++ )
                node = node.getNext();
        }else{
            node = tail;
            for(int i = currentSize - 1; i > position; i-- )
                node = node.getPrevious();
        }
        return node;
    }

    public E get( int position ) throws InvalidPositionException {
        if( position < 0 || position >= currentSize )
            throw new InvalidPositionException();
        if( position == 0 )
            return this.getFirst();
        else if ( position == currentSize - 1 )
                return this.getLast();
             else
                 return this.getNode(position).getElement();
    }

    public void addFirst(E element) {
        DoubleListNode<E> newNode = new DoubleListNode<>(element, head, null);
        if( this.isEmpty() )
            tail = newNode;
        else
            head.setPrevious(newNode);
        head = newNode;
        currentSize++;
    }

    public void addLast(E element) {
        DoubleListNode<E> newNode = new DoubleListNode<>(element, null, tail);
        if( this.isEmpty() )
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        currentSize++;
    }

    protected void addMiddle(int position, E element) {
        DoubleListNode<E> next = getNode(position);
        DoubleListNode<E> previous = next.getPrevious();
        DoubleListNode<E> newNode = new DoubleListNode<>(element, next, previous);
        next.setPrevious(newNode);
        previous.setNext(newNode);
        currentSize++;
    }

    public void add(int position, E element) throws InvalidPositionException {

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
        DoubleListNode<E> node = head;
        int position = 0;
        while( node != null && node.getElement().equals(element)) {
            position++;
            node = node.getNext();
        }
        if( node == null )
            return -1;
        else
            return position;
    }

    public boolean remove(E element) {
        return false;
    }
}
