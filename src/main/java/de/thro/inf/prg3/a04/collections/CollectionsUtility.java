package de.thro.inf.prg3.a04.collections;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/23/17.
 */
public abstract class CollectionsUtility {

	private CollectionsUtility() {
	}

	/**
	 * Sort a SimpleList with by applying the MergeSort algorithm
	 *
	 * @param cmp Comparator instance to be able to sort any type
	 * @return sorted SimpleList
	 */
	public static <T> SimpleList<T> sort(SimpleList<T> list, Comparator<T> cmp) {
		if (list.size() == 1) return list;
		return merge(sort(left(list), cmp), sort(right(list), cmp), cmp);
	}

	/**
	 * Merge two list parts into one by sorting them with the given Comparator
	 *
	 * @param left  left part of a list
	 * @param right right part of a list
	 * @param cmp   Comparator to merge the two lists in a sorted way
	 * @param <T>   type of the lists
	 * @return sorted, merged list
	 */
	private static <T> SimpleList<T> merge(SimpleList<T> left, SimpleList<T> right, Comparator<T> cmp) {

		/* recursion condition */
		if (left.size() == 0) return right;
		if (right.size() == 0) return left;
		SimpleList<T> result = createNew(left.getClass());

		/* create iterators */
		Iterator<T> leftIt = left.iterator();
		Iterator<T> rightIt = right.iterator();
		T leftElem = null;
		T rightElem = null;

		do {
			if (leftElem == null) leftElem = leftIt.hasNext() ? leftIt.next() : null;
			if (rightElem == null) rightElem = rightIt.hasNext() ? rightIt.next() : null;

			/* if both temp values have a value - compare them to sort the lists */
			if (leftElem != null && rightElem != null) {
				int cmpResult = cmp.compare(leftElem, rightElem);

				/* right element is smaller - insert right */
				if (cmpResult > 0) {
					result.add(rightElem);
					rightElem = null;

					/* left element is smaller - insert left */
				} else if (cmpResult < 0) {
					result.add(leftElem);
					leftElem = null;

					/* both elements are equals = insert both */
				} else {
					result.add(rightElem);
					result.add(leftElem);
					rightElem = null;
					leftElem = null;
				}

				/* right temp element not inserted */
			} else if (rightElem != null) {
				result.add(rightElem);
				rightElem = null;

				/* left temp element not inserted */
			} else if (leftElem != null) {
				result.add(leftElem);
				leftElem = null;
			}

			/* loop until both iterators are empty and no temp element has a value any more */
		} while (leftIt.hasNext() || rightIt.hasNext() || (leftElem != null || rightElem != null));

		return result;
	}

	/**
	 * Get the left the side of the list
	 *
	 * @param list list to split
	 * @param <T>  type of the list
	 * @return left side of the list
	 */
	private static <T> SimpleList<T> left(SimpleList<T> list) {

		/* return the list if list has only one or none element */
		if (list.size() <= 1) return list;
		SimpleList<T> left = createNew(list.getClass());
		int sizeHalf = list.size() / 2;
		Iterator<T> it = list.iterator();
		int i = 0;

		/* add the current element of the iterator to the list
		 * until the counter reaches the middle of the list */
		while (i < sizeHalf && it.hasNext()) {
			left.add(it.next());
			i++;
		}
		return left;
	}

	/**
	 * Get the right side of the list
	 *
	 * @param list list to split
	 * @param <T>  type of the list
	 * @return right side of the list
	 */
	private static <T> SimpleList<T> right(SimpleList<T> list) {

		/* return the list if list has only one or none element */
		if (list.size() <= 1) return list;
		SimpleList<T> right = createNew(list.getClass());
		int sizeHalf = list.size() / 2;
		Iterator<T> it = list.iterator();
		int i = 0;
		while (i < list.size() && it.hasNext()) {
			if (i < sizeHalf) {

				/* continue until the middle of the list */
				it.next();
				i++;
				continue;
			}

			/* add all elements including the middle item */
			right.add(it.next());
			i++;
		}
		return right;
	}

	/**
	 * Create a new instance of the current list implementation
	 *
	 * @param clazz Class of the list implementation
	 * @param <T>   runtime type of the list to sort
	 * @return new instance of the SimpleList implementation
	 * @implNote fallback to SimpleListImpl if no new instance can be created
	 */
	@SuppressWarnings("unchecked")
	private static <T> SimpleList<T> createNew(Class<? extends SimpleList> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return new SimpleListImpl<>();
		}
	}
}
