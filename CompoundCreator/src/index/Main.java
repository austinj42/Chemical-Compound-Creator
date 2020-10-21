package index;

import java.io.IOException;
import java.util.Scanner;

import compounds.Compound;
import display.GUI;
import elements.Element;
import elements.ElementManager;

public class Main {

	private static final String PATH = "elements.txt";
	
	public static void main(String[] args) throws IOException {
		ElementManager eManager = new ElementManager();
		eManager.readFile(PATH);
		//System.out.println(eManager.elementListToString());
		GUI gui = new GUI(eManager);
	}
}
