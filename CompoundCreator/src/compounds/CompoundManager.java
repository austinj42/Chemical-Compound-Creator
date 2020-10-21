package compounds;

import java.util.ArrayList;

import elements.Element;

public class CompoundManager {
	private ArrayList<Compound> compoundList;
	
	public CompoundManager() {
		compoundList = new ArrayList<Compound>();
	}

	public ArrayList<Compound> getCompoundList() {
		return compoundList;
	}

	public void setCompoundList(ArrayList<Compound> compoundList) {
		this.compoundList = compoundList;
	}
	

	public String compoundListToString() {
		String s = "";
		for(Compound c: compoundList) {
			s += c.getName();
			s += " ";
			s += c.getFormula();
			s += "\n";
		}
		return s;
	}
}
