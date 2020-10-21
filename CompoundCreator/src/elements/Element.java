package elements;

public class Element {
	private int atomicNum;
	private String name;
	private String symbol;
	private double mass;
	private String state;
	private String group;
	
	public Element (int atomicNum, String name, String symbol, double mass, int state, int group) {
		this.atomicNum = atomicNum;
		this.name = name;
		this.symbol = symbol;
		this.mass = mass;
		this.state = computeState(state);
		this.group = computeGroup(group);
	}
	
	private String computeState(int in) {
		String s = "";
		if(in == 1) {
			s = "Solid";
		}else if(in == 2) {
			s = "Liquid";
		}else if(in == 3) {
			s = "Gas";
		}else {
			s = "Unknown"; 
		}
		return s;
	}
	
	private String computeGroup(int in) {
		String s = "";
		if(in == 1) {
			s = "Alkali Metal";
		}else if(in == 2) {
			s = "Alkaline Earth Metal";
		}else if(in == 3) {
			s = "Lanthanoid";
		}else if(in == 4) {
			s = "Actinoid";
		}else if(in == 5) {
			s = "Transition Metal";
		}else if(in == 6) {
			s = "Post-Transition metal";
		}else if(in == 7) {
			s = "Metalloid";
		}else if(in == 8) {
			s = "Reactive Nonmetal";
		}else if(in == 9) {
			s = "Noble gas";
		}else {
			s = "Unknown"; 
		}
		return s;
	}
	
	public String toString() {
		return String.format("%-15d%-15s%-15s%-15.4f%-15s%-15s\n", atomicNum, name, symbol, mass, state, group);
	}

	public int getAtomicNum() {
		return atomicNum;
	}
	public void setAtomicNum(int atomicNum) {
		this.atomicNum = atomicNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public String getState() {
		return state;
	}
	public void setState(int state) {
		this.state = computeState(state);
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = computeGroup(group);
	}
}
