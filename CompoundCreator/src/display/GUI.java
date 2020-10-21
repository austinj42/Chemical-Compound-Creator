package display;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import compounds.Compound;
import compounds.CompoundManager;
import elements.ElementManager;
import sorting.ListSorter;

public class GUI extends Canvas {
	private static final long serialVersionUID = 1L;
	private ListSorter ls = new ListSorter();
	private CompoundManager cm = new CompoundManager();
	
	private JTextArea t = new JTextArea(16, 100);
	private JPanel panel = new JPanel();
	private ElementManager em;
	private JComboBox sortSelection;
	private JComboBox stateSelection;
	private JTextArea compoundCreatorName;
	private JTextArea compoundCreatorFormula;
	private JTextArea compoundsCreated;
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	
	public GUI(ElementManager em) {
		this.em = em;
		JFrame frame = new JFrame("Compound Creator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 720);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.add(panel);
		
		t.setEditable(false);
		t.setFont(new Font("Courier New", Font.PLAIN, 12));
		t.setText(em.elementListToString());
		t.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane scroll = new JScrollPane(t);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(scroll);
		
		String [] sorts = {"Atomic Number", "Name", "Symbol", "Mass"};
		sortSelection = createComboBoxSort(sorts);
		panel.add(sortSelection);
		
		String [] states = {"Solid", "Liquid", "Gas", "Unknown"};
		stateSelection = createComboBoxState(states);
		panel.add(stateSelection);
		
		compoundCreatorName = new JTextArea();
		compoundCreatorName.setFont(new Font("Courier New", Font.PLAIN, 12));
		compoundCreatorName.setText("Please input compound name.");
		compoundCreatorName.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(compoundCreatorName);
		
		compoundCreatorFormula = new JTextArea();
		compoundCreatorFormula.setFont(new Font("Courier New", Font.PLAIN, 12));
		compoundCreatorFormula.setText("Please input compound formula.\n Please use a 1 for elements that only appear once.\n Example: H2O1");
		compoundCreatorFormula.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(compoundCreatorFormula);
		
		JButton compoundFinished = new JButton();
		compoundFinished.setText("Create Compound");
		compoundFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = compoundCreatorName.getText();
				String formula = compoundCreatorFormula.getText();
				Compound c = new Compound(name, formula, em);
				cm.getCompoundList().add(c);
				compoundsCreated.setText(cm.compoundListToString());
			}
		});
		panel.add(compoundFinished);
		
		compoundsCreated = new JTextArea();
		compoundsCreated.setEditable(false);
		compoundsCreated.setFont(new Font("Courier New", Font.PLAIN, 12));
		compoundsCreated.setText(cm.compoundListToString());
		compoundsCreated.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(compoundsCreated);
		
		frame.setVisible(true);
	}
	
	private JComboBox createComboBoxSort(String [] selectionItems) {
		JComboBox input = new JComboBox(selectionItems);
		input.setFont(new Font("Courier New", Font.PLAIN, 12));
		input.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  int selected = input.getSelectedIndex();
				  ls.selectSortingMethod(selected, em, em.getElementList());
				  //System.out.println("Selection passed");
				  t.setText(em.sortedElementListToString());
				  t.setCaretPosition(0);
			  }
		});
		return input;
	}
	
	private JComboBox createComboBoxState(String [] selectionItems) {
		JComboBox input = new JComboBox(selectionItems);
		input.setFont(new Font("Courier New", Font.PLAIN, 12));
		input.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  int selectedSort = sortSelection.getSelectedIndex();
				  int selectedState = stateSelection.getSelectedIndex();
				  ls.selectState(selectedState, selectedSort, em);
				  //System.out.println("Selection passed");
				  t.setText(em.sortedElementListToString());
				  t.setCaretPosition(0);
			  }
		});
		return input;
	}
}
