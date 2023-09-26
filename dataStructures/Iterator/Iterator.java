package dataStructures.Iterator;

public interface Iterator<E>{

    /**
     *
     * @return
     */
    boolean hasNext( );

    /**
     *
     * @return
     * @throws NoSuchElementException
     */
    E next( ) throws NoSuchElementException;

    /**
     *
     */
    void rewind( );
}
