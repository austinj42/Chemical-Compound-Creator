package elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ElementManager {
	private ArrayList<Element> eList;
	private ArrayList<Element> sortedList;
	
	public ElementManager() {
		eList = new ArrayList<Element>();
	}
	
	public ElementManager(ArrayList<Element> e) {
		eList = e;
	}

	public void readFile(String path) throws IOException {
		//try to read in list of elements
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			//eats the first line, it is not needed
			br.readLine();
			
			//checks if next line read is null for end of file
			//if not reads in the next element
			while((line = br.readLine()) != null) {
				//split string on any number of spaces
				String [] temp = line.split("\\s+");
				//create element to add to element list
				Element tempElement = new Element(
						Integer.parseInt(temp[0]), temp[1], temp[2], 
						Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5])
				);
				//add element to list
				eList.add(tempElement);
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//set sorted list equal to element list to make sorting easier in list sorter
		sortedList = eList;
	}
	
	public ArrayList<Element> getElementList() {
		return eList;
	}

	public void setElementList(ArrayList<Element> eList) {
		this.eList = eList;
	}
	
	public ArrayList<Element> getSortedList() {
		return sortedList;
	}

	public void setSortedList(ArrayList<Element> sortedList) {
		this.sortedList = sortedList;
	}
	
	public String elementListToString() {
		String s = "";
		for(Element e: eList) {
			s += e.toString();
		}
		return s;
	}
	
	public String sortedElementListToString() {
		String s = "";
		for(Element e: sortedList) {
			s += e.toString();
		}
		return s;
	}
}
