package de.thro.inf.prg3.a04.tests;

import de.thro.inf.prg3.a04.collections.SimpleFilter;
import de.thro.inf.prg3.a04.collections.SimpleListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListTest
{
    private SimpleListImpl<Integer> testList;

    @BeforeEach
    void setup()
    {
        testList = new SimpleListImpl<>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
    }

    @Test
    void testAddElements()
    {
        int counter = 0;
        for (Integer i : testList)
        {
            counter ++;
        }
        assertEquals(5, counter);
    }

    @Test
    void testSize()
    {
        assertEquals(5, testList.size());
    }

    @Test
    void testFilterAnonymousClass()
    {
        SimpleListImpl<Integer> result = (SimpleListImpl<Integer>) testList.filter(new SimpleFilter<Integer>()
        {
            @Override
            public boolean include(Integer item)
            {
                return item > 2;
            }
        });

        for (Integer i : result)
            assertTrue(i > 2);
    }

    @Test
    void testFilterLambda()
    {
        SimpleListImpl<Integer> result = (SimpleListImpl<Integer>) testList.filter(i -> i % 2 == 0);

        for (Integer i : result)
            assertTrue(i % 2 == 0);
    }

    @Test
    void testFilterThirdNumber()
    {
        SimpleListImpl<Integer> filtered = (SimpleListImpl<Integer>) testList.filter(element -> element > 3);

        filtered.forEach(element -> assertTrue(element > 3));
    }
}