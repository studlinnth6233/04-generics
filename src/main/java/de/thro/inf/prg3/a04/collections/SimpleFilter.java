package de.thro.inf.prg3.a04.collections;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */

/**
 * Functional Interface for simple Filter
 *
 * @param <T> Generic type for the Element to filter
 */
@FunctionalInterface
public interface SimpleFilter<T>
{
    /**
     * @param item Item to evaluate
     *
     * @return true if the referenced object should be included.
     */
    boolean include(T item);
}