package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Code extends JDialog {

	

	/**
	 * Create the dialog.
	 */
	public Code(String code) {
		setVisible(true);
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 484);
		getContentPane().add(scrollPane);
		
		JTextArea codeArea = new JTextArea();
		scrollPane.setViewportView(codeArea);
		codeArea.setText(code);
		codeArea.setEditable(false);

	}
}
