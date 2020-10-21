package sorting;

import elements.ElementManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JTextArea;

import elements.Element;

public class ListSorter {
	
	public ListSorter() {
		
	}
	
	//accepts an int selection which is the selected index in the dropbox for sort selection,
	//an element manager which holds a list of all elements, and a list of sorted elements
	//and an array List which is the element list to be sorted
	public void selectSortingMethod(int selection, ElementManager em, ArrayList<Element> eList) {
		if(selection == 0) {
			em.setSortedList(new SortByNumber().sortByNumber(eList));
		}else if(selection == 1) {
			em.setSortedList(new SortByName().sortByName(eList));
		}else if(selection == 2) {
			em.setSortedList(new SortBySymbol().sortBySymbol(eList));
		}else if(selection == 3) {
			em.setSortedList(new SortByAtomicMass().sortByAtomicMass(eList));
		}
	}
	
	//accepts an int for the selected index in the dropbox for state selection,
	//an in for the selected index in the dropbox for sort selection
	//and an element manager which contains the list of all elements
	public void selectState(int stateSelection, int sortSelection, ElementManager em) {
		ArrayList<Element> unsortedList = em.getElementList();
		ArrayList<Element> temp = new ArrayList<Element>();
		
		//creates a list of all elements that match the selected state
		//passes this list to be sorted
		
		if(stateSelection == 0) {
			//for every element in the element list
			for(Element e: unsortedList) {
				//if the state is solid then add this element to the temp list
				if(e.getState() == "Solid") {
					temp.add(e);
				}
			}
			//pass the sort selection, the element manager, and the temp list to be sorted
			selectSortingMethod(sortSelection, em, temp);
		}
		
		if(stateSelection == 1) {
			for(Element e: unsortedList) {
				if(e.getState() == "Liquid") {
					temp.add(e);
				}
			}
			selectSortingMethod(sortSelection, em, temp);
		}
		
		if(stateSelection == 2) {
			for(Element e: unsortedList) {
				if(e.getState() == "Gas") {
					temp.add(e);
				}
			}
			selectSortingMethod(sortSelection, em, temp);
		}
		
		if(stateSelection == 3) {
			for(Element e: unsortedList) {
				if(e.getState() == "Unknown") {
					temp.add(e);
				}
			}
			selectSortingMethod(sortSelection, em, temp);
		}
	}
}
