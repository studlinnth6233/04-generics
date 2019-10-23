package de.thro.inf.prg3.a04.collections;

import java.util.function.Function;

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
        SimpleList<E> filtered = this.newInstance();

        for (E element : this)
            if (filter.include(element))
                filtered.add(element);

        return filtered;
    }

    /**
     * Create a new List containing all Elements transformed using the give Function
     *
     * @param transform Function specifying the transformation operation
     * @param <R>       The Type of the Elements after the transformation
     *
     * @return List containing transformed Elements
     */
    default <R> SimpleList<R> map(Function<E, R> transform)
    {
        SimpleList<R> transformed = this.newInstance();

        for (E element : this)
            transformed.add(transform.apply(element));

        return transformed;
    }

    /**
     * Create a new instance of the List
     *
     * @return New instance of the List
     */
    default SimpleList newInstance()
    {
        try
        {
            return this.getClass().newInstance();
        }

        catch (InstantiationException | IllegalAccessException e)
        {
            return new SimpleListImpl();
        }
    }
}