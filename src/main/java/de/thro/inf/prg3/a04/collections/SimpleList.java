package de.thro.inf.prg3.a04.collections;

/**
 * Interface for a simple List
 *
 * @param <E> Generic type for each Element of the List
 */
public interface SimpleList<E> extends Iterable<E>
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
     * Create a new List containing all Elements matching the given Filter
     *
     * @param filter The Filter to check
     *
     * @return List containing all Elements matching the Filter
     */
    default SimpleList<E> filter(SimpleFilter<E> filter)
    {
        SimpleList<E> filtered = new SimpleListImpl<>();

        for (E element : this)
            if (filter.include(element))
                filtered.add(element);

        return filtered;
    }
}