package de.thro.inf.prg3.a04.collections;

/**
 * Interface for a simple List
 *
 * @param <E> Generic type for each Element of the List
 */
public interface SimpleList<E>
{
    /**
     * Add a given object to the back of the list.
     */
    void add(E e);

    /**
     * @return current size of the list
     */
    int size();

    /**
     * Generate a new list using the given filter instance.
     *
     * @return a new, filtered list
     */
    SimpleList filter(SimpleFilter<E> filter);
}