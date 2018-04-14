import java.util.Comparator;


/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator. As
 * written uses Quicksort algorithm.
 *
 * @author CS221
 */
public class Sort {
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. As
	 * configured, uses WrappedDLL. Must be changed if using your own
	 * IUDoubleLinkedList class.
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	private static <T> IndexedUnsortedList<T> newList() {
		return new WrappedDLL<T>(); // TODO: replace with your
		// IUDoubleLinkedList for extra-credit
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface using
	 * compareTo() method defined by class of objects in list. DO NOT MODIFY
	 * THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList
	 *            interface
	 * @see IndexedUnsortedList
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) {
		quicksort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface using
	 * given Comparator. DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList
	 *            interface
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList
	 */
	public static <T> void sort(IndexedUnsortedList<T> list, Comparator<T> c) {
		quicksort(list, c);
	}

	/**
	 * Quicksort algorithm to sort objects in a list that implements the
	 * IndexedUnsortedList interface, using compareTo() method defined by class
	 * of objects in list. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList
	 *            interface
	 */
	private static <T extends Comparable<T>> void quicksort(IndexedUnsortedList<T> list) {
		IndexedUnsortedList<T> less = newList();
		IndexedUnsortedList<T> greater = newList();
		if (list.size() > 1) {

			while (list.size() > 1) {
				if (list.first().compareTo(list.last()) < 0) {
					less.addToRear(list.removeFirst());

				} else {
					greater.addToFront(list.removeFirst());
				}

			}
			quicksort(less);
			quicksort(greater);

		}
		while (!greater.isEmpty()) {
			list.addToRear(greater.removeFirst());

		}
		while (!less.isEmpty()) {
			list.addToFront(less.removeLast());
		}

	}

	/**
	 * Quicksort algorithm to sort objects in a list that implements the
	 * IndexedUnsortedList interface, using the given Comparator. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList
	 *            interface
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void quicksort(IndexedUnsortedList<T> list, Comparator<T> c) {
		IndexedUnsortedList<T> less = newList();
		IndexedUnsortedList<T> greater = newList();
		if (list.size() > 1) {

			while (list.size() > 1) {
				if (c.compare(list.first(), list.last()) < 0) {
					less.addToRear(list.removeFirst());

				} else {
					greater.addToFront(list.removeFirst());
				}

			}

			quicksort(less, c);
			quicksort(greater, c);
		}

		while (!greater.isEmpty()) {
			list.addToRear(greater.removeFirst());

		}
		while (!less.isEmpty()) {
			list.addToFront(less.removeLast());
		}

	}

}