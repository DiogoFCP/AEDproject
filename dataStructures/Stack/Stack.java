package dataStructures.Stack;

import java.util.EmptyStackException;

public interface Stack<E> {

    /**
     *
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
     * @throws EmptyStackException
     */
    E top() throws EmptyStackException;

    /**
     *
     * @param element
     * @throws FullStackException
     */
    void push(E element) throws FullStackException;

    /**
     *
     * @return
     * @throws EmptyStackException
     */
    E pop() throws EmptyStackException;
}
