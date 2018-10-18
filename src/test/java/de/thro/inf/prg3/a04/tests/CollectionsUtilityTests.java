package de.thro.inf.prg3.a04.tests;

import de.thro.inf.prg3.a04.collections.CollectionsUtility;
import de.thro.inf.prg3.a04.collections.SimpleList;
import de.thro.inf.prg3.a04.collections.SimpleListImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/23/17.
 */
class CollectionsUtilityTests {

	private final Logger logger = LogManager.getLogger();
	private SimpleList<Integer> testList;

	@BeforeEach
	void setup(){
		testList = new SimpleListImpl<>();

		testList.add(4);
		testList.add(3);
		testList.add(6);
		testList.add(3);
		testList.add(5);
		testList.add(7);
		testList.add(2);
		testList.add(1);
	}

	@Test
	void testSortList() {
		SimpleList<Integer> sorted = CollectionsUtility.sort(testList, Comparator.comparingInt(i -> i));
		assertEquals(8, sorted.size());
		int tmp = -1;
		for(Integer i : sorted) {
			assertTrue(i >= tmp);
			tmp = i;
		}
	}
}
