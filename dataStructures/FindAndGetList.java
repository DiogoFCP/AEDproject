package dataStructures;

/**
 * List but with a method that finds and returns an element in a single search.
 *
 * @param <E> Generic Element
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface FindAndGetList<E> extends List<E> {

    /**
     * Returns the first occurrence of the specified element
     * in the list, if the list contains the element.
     * Otherwise, returns null.
     *
     * @param element - element to be searched in list.
     * @return the element we are trying to find.
     */
    E findAndGet(E element);
}
