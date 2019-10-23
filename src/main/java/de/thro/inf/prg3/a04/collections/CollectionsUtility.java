package de.thro.inf.prg3.a04.collections;

import java.util.Comparator;
import java.util.Iterator;

public abstract class CollectionsUtility
{
    /**
     * Sort the List using a InsertionSort style algorithm
     *
     * @param list       The List to sort
     * @param comparator The comparator to using during sorting
     *
     * @return The sorted List
     */
    public static <E> SimpleList<E> sort(SimpleList<E> list, Comparator<E> comparator)
    {
        SimpleList<E> sorted = list.newInstance();

        int[] indices = new int[list.size()];
        for (int i = 0; i < indices.length; i ++)
            indices[i] = - 1;

        for (int iteration = 0; iteration < list.size(); iteration ++)
        {
            Iterator<E> iterator = list.iterator();
            E value = null;

            E   insertionValue = null;
            int insertionIndex = -1;

            for (int index = 0; index < list.size(); index ++)
            {
                value = iterator.next();

                boolean insertedAlready = false;

                for (int indexInserted : indices)
                    if (index == indexInserted)
                        insertedAlready = true;

                if (insertedAlready)
                    continue;

                if (insertionValue == null)
                {
                    insertionValue = value;
                    insertionIndex = index;
                }

                else
                {
                    if (comparator.compare(value, insertionValue) > 0)
                    {
                        insertionValue = value;
                        insertionIndex = index;
                    }
                }
            }

            sorted.add(insertionValue);

            for (int i = 0; i < indices.length; i ++)
            {
                if (indices[i] == -1)
                {
                    indices[i] = insertionIndex;
                    break;
                }
            }
        }

        return sorted;
    }
}