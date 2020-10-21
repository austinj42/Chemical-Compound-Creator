package compounds;

import java.util.ArrayList;
import java.util.HashMap;

import elements.Element;
import elements.ElementManager;

public class Compound {
	private HashMap<String, Integer> compoundElementCounts;
	private ArrayList<Element> compoundElements;
	private String name;
	private String formula;
	
	public Compound(String name, String formula, ElementManager em) {
		this.name = name;
		this.formula = formula;
		compoundElementCounts = new HashMap<String, Integer>();
		compoundElements = new ArrayList<Element>();
		splitString(formula);
		for(String key: compoundElementCounts.keySet()) {
			searchForElement(key, em);
		}
	}
	
	public void printMap() {
		for (String name: compoundElementCounts.keySet()){
			System.out.println(name + compoundElementCounts.get(name));
		} 
	}
	
	private void splitString(String s) {
		String temp = "";
		for(int i = 0; i < s.length(); i ++) {
			if(Character.isDigit(s.charAt(i))) {
				compoundElementCounts.put(temp, Integer.parseInt(String.valueOf(s.charAt(i))));
				temp = "";
			}else {
				temp += s.charAt(i);
			}
		}
	}
	
	private void searchForElement(String s, ElementManager em) {
		for(Element e: em.getElementList()) {
			if(e.getSymbol() == s) {
				compoundElements.add(e);
			}
		}
	}

	public HashMap<String, Integer> getCompoundElementCounts() {
		return compoundElementCounts;
	}

	public void setCompoundElementCounts(HashMap<String, Integer> compoundElementCounts) {
		this.compoundElementCounts = compoundElementCounts;
	}

	public ArrayList<Element> getCompoundElements() {
		return compoundElements;
	}

	public void setCompoundElements(ArrayList<Element> compoundElements) {
		this.compoundElements = compoundElements;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
}
