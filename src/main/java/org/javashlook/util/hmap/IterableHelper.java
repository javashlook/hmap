package org.javashlook.util.hmap;

import java.util.Iterator;

final class IterableHelper {

	private IterableHelper() {}
	
	/**
	 * Gets either the only element or the default one. If there are multiple elements in <tt>source</tt>, an
	 * {@link IllegalStateException} is thrown.
	 */
	public static <T> T unique(Iterable<T> source, T defaultElement) {
		T element = defaultElement;

		if (source != null) {
			Iterator<T> i = source.iterator();

			if (i.hasNext()) {
				element = i.next();

				if (i.hasNext()) {
					throw new IllegalStateException("Element not unique!");
				}
			}
		}

		return element;
	}

}
