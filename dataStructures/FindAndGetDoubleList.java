package dataStructures;

/**
 * Double list but with a method that finds and returns an element in a single search (implementation).
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 * @param <E> Generic Element
 */
public class FindAndGetDoubleList<E> extends DoubleList<E> implements FindAndGetList<E>{

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * TODO
     */
    public FindAndGetDoubleList(){
        super();
    }

    public E findAndGet(E element) {
        DoubleListNode<E> node = head;
        while(node != null && !node.getElement().equals(element)){
            node = node.getNext();
        }
        if( node == null )
            return null;
        else
            return node.getElement();
    }
}
