package de.thro.inf.prg3.a04.collections;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object>
{
    /**
     * Inner class for one Element of the List
     */
    private static class Element
    {
        Object  item;
        Element next;

        /**
         * Constructor
         * Sets the item to store in the Element
         *
         * @param item The item to store in the Element
         */
        Element(Object item)
        {
            this.item = item;
        }
    }

    /**
     * Inner class for the Iterator of the List
     */
    private class SimpleIteratorImpl implements Iterator<Object>
    {
        Element current = head;

        /**
         * Check if there is one more Element in the List
         *
         * @return True / False whether there is one more Element in the List
         */
        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        /**
         * Return the value of the next Element in the List
         *
         * @return Value of next Element
         */
        @Override
        public Object next()
        {
            Object value = current.item;

            current = current.next;

            return value;
        }
    }

    private Element head;

    /**
     * Return a new Instance of the Iterator of the List
     *
     * @return New Instance of the Iterator
     */
    @Override
    public Iterator<Object> iterator()
    {
        return new SimpleIteratorImpl();
    }

    /**
     * Add a new Element to the back of the List
     *
     * @param o The Value to store
     */
    @Override
    public void add(Object o)
    {
        Element tail = head;

        while (tail != null && tail.next != null)
            tail = tail.next;

        if (head == null) head      = new Element(o);
        else              tail.next = new Element(0);
    }

    /**
     * Get the size of the List
     *
     * @return The size of the List
     */
    @Override
    public int size()
    {
        int count = 0;

        for (Object element : this)
            count ++;

        return count;
    }

    /**
     * Create a new List containing all Elements matching the given Filter
     *
     * @param filter The Filter to check
     *
     * @return List containing all Elements matching the Filter
     */
    @Override
    public SimpleList filter(SimpleFilter filter)
    {
        SimpleList filtered = new SimpleListImpl();

        for (Object element : this)
            if (filter.include(element))
                filtered.add(element);

        return filtered;
    }
}