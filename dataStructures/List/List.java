package dataStructures.List;

import dataStructures.Iterator.Iterator;

public interface List<E> {

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @return
     */
    int size();

    /**
     *
     * @return
     */
    Iterator<E> iterator();

    /**
     *
     * @return
     * @throws EmptyListException
     */
    E getFirst( ) throws EmptyListException;

    /**
     *
     * @return
     * @throws EmptyListException
     */
    E getLast( ) throws EmptyListException;

    /**
     *
     * @param position
     * @return
     * @throws InvalidPositionException
     */
    E get( int position ) throws InvalidPositionException;

    /**
     *
     * @param element
     */
    void addFirst ( E element );

    /**
     *
     * @param element
     */
    void addLast ( E element );

    /**
     *
     * @param position
     * @param element
     */
    void add ( int position, E element ) throws InvalidPositionException;

    /**
     *
     * @return
     * @throws EmptyListException
     */
    E removeFirst( ) throws EmptyListException;

    /**
     *
     * @return
     * @throws EmptyListException
     */
    E removeLast( ) throws EmptyListException;

    /**
     *
     * @param position
     * @return
     * @throws InvalidPositionException
     */
    E remove( int position ) throws InvalidPositionException;

    /**
     *
     * @param element
     * @return
     */
    int find( E element );

    /**
     *
     * @param element
     * @return
     */
    boolean remove( E element );
}