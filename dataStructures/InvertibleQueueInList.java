package dataStructures;

import dataStructures.exceptions.EmptyQueueException;

public class InvertibleQueueInList<E> extends QueueInList<E> implements InvertibleQueue<E> {

    static final long serialVersionUID = 0L;

    boolean leftToRight;

    public InvertibleQueueInList() {
        super();
        leftToRight = true;
    }

    public void invert() {
        leftToRight = !leftToRight;
    }

    public void equeue(E element) {
        if (leftToRight)
            list.addLast(element);
        else
            list.addFirst(element);
    }

    public E dequeue() throws EmptyQueueException {
        if (list.isEmpty())
            throw new EmptyQueueException();

        if (leftToRight)
            return list.removeFirst();
        else
            return list.removeLast();
    }
}
