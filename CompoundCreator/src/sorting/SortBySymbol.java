package sorting;

import java.util.ArrayList;

import elements.Element;
import elements.ElementManager;

public class SortBySymbol {
	public ArrayList<Element> sortBySymbol(ArrayList<Element> list) {
		int n = list.size();

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if ((list.get(j).getSymbol().compareTo(list.get(min_idx).getSymbol())) < 0) {
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			Element temp = list.get(min_idx);
			list.set(min_idx, list.get(i));
			list.set(i, temp);
		}

		return list;
	}
}
